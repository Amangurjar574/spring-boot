package com.example.demo.serviceimpl;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl  implements UserService {
    HashMap<Integer,User> hashSet=new HashMap<>();

    @Override
    public User createUser(User user) {
        User user1=new User(user.getId(),user.getName(),user.getPassword());
        hashSet.put(user.getId(),user1);
        return hashSet.get(user1.getId());
    }
    @Override
    public User deleteUser(Integer id) {
        return hashSet.remove(id);
    }
    @Override
    public User UpdateUSer(User user) {
        User user1=hashSet.get(user.getId());
        user1.setName(user.getName());
        user1.setPassword(user.getPassword());
        hashSet.put(user.getId(),user1);
        return user1;
    }

    @Override
    public User getUser(Integer id) {
        return hashSet.get(id);
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(hashSet.values());
    }

}
