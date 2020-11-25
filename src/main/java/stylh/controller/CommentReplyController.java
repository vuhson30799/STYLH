package stylh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import stylh.model.CommentReply;
import stylh.service.CommentReplyService;

import java.util.List;

public class CommentReplyController {
    @Autowired
    private CommentReplyService commentReplyService;


    @RequestMapping(value = "/commentReply/", method = RequestMethod.GET)
    public ResponseEntity<List<CommentReply>> listAllCommentReply() {
        List<CommentReply> commentReplys = commentReplyService.findAll();
        if (commentReplys.isEmpty()) {
            return new ResponseEntity<List<CommentReply>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<CommentReply>>(commentReplys, HttpStatus.OK);
    }


    @RequestMapping(value = "/commentReplys/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommentReply> getCommentReply(@PathVariable("id") long id) {
        System.out.println("Fetching commentReply with id " + id);
        CommentReply commentReply = commentReplyService.findById(id);
        if (commentReply == null) {
            System.out.println("commentReply with id " + id + " not found");
            return new ResponseEntity<CommentReply>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CommentReply>(commentReply, HttpStatus.OK);
    }
}
