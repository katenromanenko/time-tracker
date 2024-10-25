package com.example.timetracker.service;

import com.example.timetracker.model.User;
import com.example.timetracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        if (user == null) {
            throw new NullPointerException("User cannot be null");
        }
        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        return userRepository.findByUsername(username);
    }

    public Optional<User> findById(Long id) {
        if (id == null) {
            throw new NullPointerException("Id cannot be null");
        }
        return userRepository.findById(id);
    }

    public void deleteUser(Long id) {
        if (id == null) {
            throw new NullPointerException("Id cannot be null");
        }
        userRepository.deleteById(id);
    }
}

