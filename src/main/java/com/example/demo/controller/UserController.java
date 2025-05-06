package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/user")
    User createUser(@RequestBody User user)
    {
       return  userService.createUser(user);
    }
    @DeleteMapping("/delete")
    User deleteUser(@RequestParam("id") Integer id)
    {
       return  userService.deleteUser(id);
    }
    @PutMapping("/update")
    public User updateUser(@RequestBody User user)
    {
        return userService.UpdateUSer(user);
    }
    @GetMapping("/user{id}")
    public List<User> getUser(@PathVariable("id") Integer id)
    {
        if (id!=null)
        return List.of(userService.getUser(id));
        else
            return userService.getAll();
    }





    @GetMapping("/name")
   public  String getName(@RequestParam(value = "id" , required = false) Integer id)
    {
        HashMap<Integer,String> li=new HashMap<>();
        li.put(1,"aaa");
        li.put(2,"bbb");
        li.put(3,"ccc");
        li.put(4,"ddd");
        li.put(5,"eee");
        li.put(6,"fff");
        li.put(7,"ggg");
        if(id!=null){
            String name=li.get(id);
            if(name!=null)return name;
            else return "not found..";
        }
        return li.values().toString();
    }


}

