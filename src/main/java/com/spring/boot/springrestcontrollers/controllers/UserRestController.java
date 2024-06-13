package com.spring.boot.springrestcontrollers.controllers;

import com.spring.boot.springrestcontrollers.entity.User;
import com.spring.boot.springrestcontrollers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(value = "/principal")
    public ResponseEntity<User> getUser(@AuthenticationPrincipal User user){
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }
}
