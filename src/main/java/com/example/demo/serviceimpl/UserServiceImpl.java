package com.example.demo.serviceimpl;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;

@Service
public class UserServiceImpl  implements UserService {

    HashMap<Integer,User> hashSet=new HashMap<>();

    @Override
    public User createUser(User user) {
        User user1=new User(user.getId(),user.getName(),user.getPassword());
        hashSet.put(user.getId(),user1);
        return hashSet.get(user1.getId());
    }
}
