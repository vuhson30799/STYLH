package stylh.controller;

import org.json.JSONObject;
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

import java.util.ArrayList;
import java.util.List;

@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;


    @RequestMapping(value = "/topics/", method = RequestMethod.GET)
    public ResponseEntity<List<JSONObject>> listAllTopics() {
        List<Topic> topics = topicService.findAll();
        if (topics.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<JSONObject> objects = new ArrayList<>();
        JSONObject object;

        for(Topic topic : topics){
            object = new JSONObject();

            object.put("topicID",topic.getTopicID());
            object.put("topicName",topic.getTopicName());
            object.put("threadNumber",topic.getThreadNumber());
            object.put("commentNumber",topic.getCommentNumber());

            objects.add(object);
        }
        return new ResponseEntity<>(objects, HttpStatus.OK);
    }


    @RequestMapping(value = "/topics/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JSONObject> getTopic(@PathVariable("id") long id) {
        System.out.println("Fetching topic with id " + id);
        Topic topic = topicService.findById(id);
        if (topic == null) {
            System.out.println("topic with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        JSONObject object = new JSONObject();

        object.put("topicID",topic.getTopicID());
        object.put("topicName",topic.getTopicName());
        object.put("threadNumber",topic.getThreadNumber());
        object.put("commentNumber",topic.getCommentNumber());
        return new ResponseEntity<>(object, HttpStatus.OK);
    }
}
