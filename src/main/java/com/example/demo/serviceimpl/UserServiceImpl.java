package com.example.demo.serviceimpl;

import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.*;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(User user) throws SQLException {
        return  userRepository.save(user);
    }
    @Override
    public User deleteUser(Integer id) {
           Optional<User> user=userRepository.findById(id);
        if(user.isPresent())
        {
            userRepository.delete(user.get());
            return user.get();
        }
            throw new UserNotFoundException("data not found id:"+id);
    }
    @Override
    public User UpdateUSer(User user) {
         Optional<User> user1=userRepository.findById(user.getId());
        if(user1.isPresent())
        {
            user1.get().setName(user.getName());
            user1.get().setPassword(user.getPassword());
            userRepository.save(user1.get());
        }
        throw new UserNotFoundException("data not found id:"+user.getId());
    }

    @Override
    public User getUser(Integer id) {
        Optional<User> user1=userRepository.findById(id);
        if (user1.isEmpty()) {
            throw new UserNotFoundException("data not found id:" + id);
        } else {
            return user1.get();
        }
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

}
