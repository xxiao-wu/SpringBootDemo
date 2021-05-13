package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class UserService {
    @Autowired
    private final UserRepository repository = null;

    public boolean exists(User user) {
        return repository.existsByName(user.getName());
    }

    public User findByNameAndPassword(User user) {
        return repository.findByNameAndPassword(user.getName(), user.getPassword());
    }

    public boolean insert(User user) {
        repository.save(user);
        return true;
    }

    public boolean update(User user) {
        if (repository.findById(user.getId()).isEmpty()) {
            return false;
        }
        repository.save(user);
        return true;
    }

    public boolean deleteById(int id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}
