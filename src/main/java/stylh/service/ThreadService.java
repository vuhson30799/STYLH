package stylh.service;

import stylh.model.Thread;

import java.util.List;

public interface ThreadService {
    List<Thread> findAll();
    Thread findById(Long id);
}
