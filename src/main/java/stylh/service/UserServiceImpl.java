package stylh.service;

import org.springframework.beans.factory.annotation.Autowired;
import stylh.model.User;
import stylh.repository.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }
}
