package com.spring.boot.springrestcontrollers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {

    @GetMapping()
    public String loginPage() {
        return "redirect:/login";
    }

    @GetMapping("user")
    public String userPage(){
        return "user";
    }

    @GetMapping("admin")
    public String adminPage(){
        return "admin";
    }

}