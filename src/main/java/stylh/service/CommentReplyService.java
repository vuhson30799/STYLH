package stylh.service;

import stylh.model.CommentReply;

import java.util.List;

public interface CommentReplyService {
    List<CommentReply> findAll();
    CommentReply findById(Long id);
}
