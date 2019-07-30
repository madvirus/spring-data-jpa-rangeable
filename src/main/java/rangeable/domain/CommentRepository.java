package rangeable.domain;

import org.springframework.data.repository.Repository;
import rangeable.jpa.RangeableExecutor;

public interface CommentRepository
        extends Repository<Comment, Long>, RangeableExecutor<Comment> {
}
