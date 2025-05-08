package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
       return  new ResponseEntity<>(userService.createUser(user),HttpStatus.CREATED);
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
    public ResponseEntity<List<User>> getUser(@RequestParam("id") Integer id)
    {
        if (id!=null)
        return new ResponseEntity<>(List.of(userService.getUser(id)), HttpStatus.OK);
        else
            return new ResponseEntity<>(userService.getAll(),HttpStatus.OK);
    }





//    @GetMapping("/name")
//   public  String getName(@RequestParam(value = "id" , required = false) Integer id)
//    {
//        HashMap<Integer,String> li=new HashMap<>();
//        li.put(1,"aaa");
//        li.put(2,"bbb");
//        li.put(3,"ccc");
//        li.put(4,"ddd");
//        li.put(5,"eee");
//        li.put(6,"fff");
//        li.put(7,"ggg");
//        if(id!=null){
//            String name=li.get(id);
//            if(name!=null)return name;
//            else return "not found..";
//        }
//        return li.values().toString();
//    }


}

