package stylh.service;

import org.springframework.beans.factory.annotation.Autowired;
import stylh.model.Thread;
import stylh.repository.ThreadRepository;

import java.util.List;

public class ThreadServiceImpl implements ThreadService {
    @Autowired
    ThreadRepository threadRepository;
    @Override
    public List<Thread> findAll() {
        return threadRepository.findAll();
    }

    @Override
    public Thread findById(Long id) {
        return threadRepository.findById(id).get();
    }
}
