package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/name")
   public  String getName(@RequestParam("name") String name)
    {
        return name;
    }
    @GetMapping("/id")
   public  String getId(@RequestParam("id") int id)
    {
        return "Id : "+id;
    }

}
