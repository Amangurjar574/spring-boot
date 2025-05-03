package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

@RestController
public class UserController {

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

