package stylh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import stylh.model.Topic;
import stylh.service.TopicService;

import java.util.List;

@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;


    @RequestMapping(value = "/topics/", method = RequestMethod.GET)
    public ResponseEntity<List<Topic>> listAllTopics() {
        List<Topic> topics = topicService.findAll();
        if (topics.isEmpty()) {
            return new ResponseEntity<List<Topic>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Topic>>(topics, HttpStatus.OK);
    }


    @RequestMapping(value = "/topics/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Topic> getTopic(@PathVariable("id") long id) {
        System.out.println("Fetching topic with id " + id);
        Topic topic = topicService.findById(id);
        if (topic == null) {
            System.out.println("topic with id " + id + " not found");
            return new ResponseEntity<Topic>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Topic>(topic, HttpStatus.OK);
    }
}
