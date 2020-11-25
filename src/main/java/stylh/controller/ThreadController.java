package stylh.controller;

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

import java.util.List;

@RestController
public class ThreadController {
    @Autowired
    private ThreadService threadService;


    @RequestMapping(value = "/threads/", method = RequestMethod.GET)
    public ResponseEntity<List<Thread>> listAllThreads() {
        List<Thread> threads = threadService.findAll();
        if (threads.isEmpty()) {
            return new ResponseEntity<List<Thread>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Thread>>(threads, HttpStatus.OK);
    }


    @RequestMapping(value = "/threads/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Thread> getThread(@PathVariable("id") long id) {
        System.out.println("Fetching thread with id " + id);
        Thread thread = threadService.findById(id);
        if (thread == null) {
            System.out.println("thread with id " + id + " not found");
            return new ResponseEntity<Thread>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Thread>(thread, HttpStatus.OK);
    }
}
