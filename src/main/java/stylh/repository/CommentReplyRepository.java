package stylh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stylh.model.CommentReply;

public interface CommentReplyRepository extends JpaRepository<CommentReply,Long> {
}
