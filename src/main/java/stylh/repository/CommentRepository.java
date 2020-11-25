package stylh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stylh.model.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
