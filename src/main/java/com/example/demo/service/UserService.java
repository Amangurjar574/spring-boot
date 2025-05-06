package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User createUser(User user);
    User deleteUser(Integer id);
    User UpdateUSer(User user);
    User getUser(Integer id);
    List<User> getAll();
}
