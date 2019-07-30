package rangeable.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comment {
    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @Column(name = "wtime")
    private LocalDateTime writtenTime;

    private Comment() {
    }

    public Comment(String content, LocalDateTime writtenTime) {
        this.content = content;
        this.writtenTime = writtenTime;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getWrittenTime() {
        return writtenTime;
    }
}
