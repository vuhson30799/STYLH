package stylh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stylh.model.Topic;

public interface TopicRepository extends JpaRepository<Topic,Long> {
}
