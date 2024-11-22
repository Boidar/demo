package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> listUsers() {
        return userRepository.findAll();
    }
    public User findById(Long id) {
        return userRepository.getOne(id);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }
    public User updateUser(User user) {
        if (userRepository.existsById(user.getId())) {
            return userRepository.save(user);
        } else {
            return null;
        }
    }
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
