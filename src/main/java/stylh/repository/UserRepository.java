package stylh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stylh.model.CommentReply;
import stylh.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
