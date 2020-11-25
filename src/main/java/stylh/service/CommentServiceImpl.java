package stylh.service;

import org.springframework.beans.factory.annotation.Autowired;
import stylh.model.Comment;
import stylh.repository.CommentRepository;

import java.util.List;

public class CommentServiceImpl implements CommentService{
    @Autowired
    CommentRepository commentRepository;
    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).get();
    }
}
