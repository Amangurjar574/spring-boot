package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.*;

@Controller
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/create")
    public String createUser(@RequestParam Integer id,
                                           @RequestParam String name,
                                           @RequestParam  String password) throws SQLException
    {
        User user=new User(id,name,password);
        User user1=userService.createUser(user);
        if(user1!=null) {
            return "redirect:/login";
        }
        return   "redirect:/login?error";
    }

    @PostMapping("/loginapi")
    public String loginUser(@RequestParam String name,
                            @RequestParam String password)
    {
        String user  =userService.login(new User(name,password));
        if (user != null) {
            return "redirect:/welcome";
        } else {
            return "redirect:/login?error";
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<User> deleteUser(@RequestParam("id") Integer id)
    {
        return new ResponseEntity<>(userService.deleteUser(id),HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user)
    {
        return new ResponseEntity<>(userService.UpdateUSer(user),HttpStatus.OK);
    }
    @GetMapping("/user")
    public ResponseEntity<List<User>> getUser(@RequestParam(value = "id" , required = false)  Integer id)
    {
        if (id!=null)
        return new ResponseEntity<>(List.of(userService.getUser(id)), HttpStatus.OK);
        else
            return new ResponseEntity<>(userService.getAll(),HttpStatus.OK);
    }

}

