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
import stylh.model.Thread;
import stylh.service.ThreadService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ThreadController {
    @Autowired
    private ThreadService threadService;


    @RequestMapping(value = "/threads/", method = RequestMethod.GET)
    public ResponseEntity<List<JSONObject>> listAllThreads() {
        List<Thread> threads = threadService.findAll();
        if (threads.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<JSONObject> objects = new ArrayList<>();
        JSONObject object;

        for(Thread thread : threads){
            object = new JSONObject();
            object.put("threadID",thread.getThreadID());
            object.put("threadType",thread.getThreadType());
            object.put("reply",thread.getReply());
            object.put("view",thread.getView());

            objects.add(object);

        }

        return new ResponseEntity<>(objects, HttpStatus.OK);
    }


    @RequestMapping(value = "/threads/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JSONObject> getThread(@PathVariable("id") long id) {
        System.out.println("Fetching thread with id " + id);
        Thread thread = threadService.findById(id);
        if (thread == null) {
            System.out.println("thread with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        JSONObject object = new JSONObject();
        object.put("threadID",thread.getThreadID());
        object.put("threadType",thread.getThreadType());
        object.put("reply",thread.getReply());
        object.put("view",thread.getView());

        return new ResponseEntity<>(object, HttpStatus.OK);
    }
}
