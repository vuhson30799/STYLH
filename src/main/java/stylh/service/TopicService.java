package stylh.service;

import stylh.model.Topic;

import java.util.List;

public interface TopicService {
    List<Topic> findAll();
    Topic findById(Long id);
}
