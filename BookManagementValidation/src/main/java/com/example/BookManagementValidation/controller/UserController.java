package com.example.BookManagementValidation.controller;

import com.example.BookManagementValidation.entity.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping("/")
    public String register(Model theModel){
        theModel.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String userForm(@Valid @ModelAttribute("user") User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "register";
        }
        return "Success";
    }
}
