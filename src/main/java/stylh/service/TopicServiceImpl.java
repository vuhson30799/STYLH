package stylh.service;

import org.springframework.beans.factory.annotation.Autowired;
import stylh.model.Topic;
import stylh.repository.TopicRepository;

import java.util.List;

public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicRepository topicRepository;
    @Override
    public List<Topic> findAll() {
        return topicRepository.findAll();
    }

    @Override
    public Topic findById(Long id) {
        return topicRepository.findById(id).get();
    }
}
