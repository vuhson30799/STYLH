package stylh.service;

import stylh.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
}
