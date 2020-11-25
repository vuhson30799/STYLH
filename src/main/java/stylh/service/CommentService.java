package stylh.service;

import stylh.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();
    Comment findById(Long id);
}
