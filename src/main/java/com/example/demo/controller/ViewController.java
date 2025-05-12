package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/home")
    public String showPage() {
        return "home";  // maps to home.jsp
    }
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // login.jsp
    }
    @GetMapping("/welcome")
    public String welcome() {
        return "welcome"; // login.jsp
    }
}
