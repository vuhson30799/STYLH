package stylh.service;

import org.springframework.beans.factory.annotation.Autowired;
import stylh.model.CommentReply;
import stylh.repository.CommentReplyRepository;

import java.util.List;

public class CommentReplyServiceImpl implements CommentReplyService{
    @Autowired
    CommentReplyRepository commentReplyRepository;

    @Override
    public List<CommentReply> findAll() {
        return commentReplyRepository.findAll();
    }

    @Override
    public CommentReply findById(Long id) {
        return commentReplyRepository.findById(id).get();
    }
}
