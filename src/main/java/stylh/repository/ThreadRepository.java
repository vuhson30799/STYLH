package stylh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stylh.model.Thread;

public interface ThreadRepository extends JpaRepository<Thread,Long> {
}
