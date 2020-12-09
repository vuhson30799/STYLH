package stylh.controller;

import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import stylh.model.CommentReply;
import stylh.service.CommentReplyService;

import java.util.ArrayList;
import java.util.List;

public class CommentReplyController {
    @Autowired
    private CommentReplyService commentReplyService;


    @RequestMapping(value = "/commentReply/", method = RequestMethod.GET)
    public ResponseEntity<List<JSONObject>> listAllCommentReply() {
        List<CommentReply> commentReplies = commentReplyService.findAll();
        if (commentReplies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<JSONObject> objects = new ArrayList<>();
        JSONObject object;
        for(CommentReply commentReply : commentReplies){
            object = new JSONObject();
            object.put("replyID",commentReply.getReplyID());
            object.put("replyContent",commentReply.getReplyContent());
            object.put("replyDate",commentReply.getReplyDate());

            objects.add(object);
        }
        return new ResponseEntity<>(objects, HttpStatus.OK);
    }


    @RequestMapping(value = "/commentReplys/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JSONObject> getCommentReply(@PathVariable("id") long id) {
        System.out.println("Fetching commentReply with id " + id);
        CommentReply commentReply = commentReplyService.findById(id);
        if (commentReply == null) {
            System.out.println("commentReply with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        JSONObject object = new JSONObject();
        object.put("replyID",commentReply.getReplyID());
        object.put("replyContent",commentReply.getReplyContent());
        object.put("replyDate",commentReply.getReplyDate());

        return new ResponseEntity<>(object, HttpStatus.OK);
    }
}
