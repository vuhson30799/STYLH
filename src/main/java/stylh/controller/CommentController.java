package stylh.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import stylh.model.Comment;
import stylh.service.CommentService;

import java.util.ArrayList;
import java.util.List;

public class CommentController {
    @Autowired
    private CommentService commentService;


    @RequestMapping(value = "/comments/", method = RequestMethod.GET)
    public ResponseEntity<List<JSONObject>> listAllComments() {
        List<Comment> comments = commentService.findAll();
        if (comments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<JSONObject> objects = new ArrayList<>();
        JSONObject object;
        for(Comment comment : comments){
            object = new JSONObject();
            object.put("commentID",comment.getCommentID());
            object.put("commentContent",comment.getCommentContent());
            object.put("commentDate",comment.getCommentDate());

            objects.add(object);
        }
        return new ResponseEntity<>(objects, HttpStatus.OK);
    }


    @RequestMapping(value = "/comments/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JSONObject> getComment(@PathVariable("id") long id) {
        System.out.println("Fetching comment with id " + id);
        Comment comment = commentService.findById(id);
        if (comment == null) {
            System.out.println("comment with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        JSONObject object = new JSONObject();
        object.put("commentID",comment.getCommentID());
        object.put("commentContent",comment.getCommentContent());
        object.put("commentDate",comment.getCommentDate());
        return new ResponseEntity<>(object, HttpStatus.OK);
    }
}
