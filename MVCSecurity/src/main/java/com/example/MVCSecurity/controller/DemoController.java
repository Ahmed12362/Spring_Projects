package com.example.MVCSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/")
    public String showHome(){
        return "home";
    }
    @GetMapping("/leaders")
    public String showManagerPage(){
        return "manager";
    }
    @GetMapping("/system")
    public String showAdminPage(){
        return "admin";
    }
    @GetMapping("/handleExc")
    public String showErrorPage(){
        return "error-handle";
    }
}
