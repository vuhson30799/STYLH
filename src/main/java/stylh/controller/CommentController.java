package stylh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import stylh.model.Comment;
import stylh.service.CommentService;

import java.util.List;

public class CommentController {
    @Autowired
    private CommentService commentService;


    @RequestMapping(value = "/comments/", method = RequestMethod.GET)
    public ResponseEntity<List<Comment>> listAllComments() {
        List<Comment> comments = commentService.findAll();
        if (comments.isEmpty()) {
            return new ResponseEntity<List<Comment>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Comment>>(comments, HttpStatus.OK);
    }


    @RequestMapping(value = "/comments/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comment> getComment(@PathVariable("id") long id) {
        System.out.println("Fetching comment with id " + id);
        Comment comment = commentService.findById(id);
        if (comment == null) {
            System.out.println("comment with id " + id + " not found");
            return new ResponseEntity<Comment>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Comment>(comment, HttpStatus.OK);
    }
}
