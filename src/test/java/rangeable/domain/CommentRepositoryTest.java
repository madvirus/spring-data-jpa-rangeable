package rangeable.domain;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import rangeable.jpa.Rangeable;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CommentRepositoryTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private CommentRepository repository;

    @Test
    public void rangeable() {
        for (int i = 1 ; i <= 40 ; i++) {
            givenComment(i, "댓글:" + i);
        }

        List<Comment> comments = repository.getRange(
                null,
                new Rangeable(10, 5, Sort.by("id").descending()));

        SoftAssertions.assertSoftly(soft -> {
            soft.assertThat(comments).hasSize(5);
            soft.assertThat(comments.get(0).getId()).isEqualTo(30);
            soft.assertThat(comments.get(1).getId()).isEqualTo(29);
            soft.assertThat(comments.get(2).getId()).isEqualTo(28);
            soft.assertThat(comments.get(3).getId()).isEqualTo(27);
            soft.assertThat(comments.get(4).getId()).isEqualTo(26);
        });
    }

    private void givenComment(int id, String content) {
        jdbcTemplate.update("insert into comment (comment_id, content, wtime) values (?, ?, ?)", id, content, LocalDateTime.now());
    }
}
