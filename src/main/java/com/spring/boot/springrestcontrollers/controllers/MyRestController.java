package com.spring.boot.springrestcontrollers.controllers;

import com.spring.boot.springrestcontrollers.entity.Role;
import com.spring.boot.springrestcontrollers.entity.User;
import com.spring.boot.springrestcontrollers.service.RoleService;
import com.spring.boot.springrestcontrollers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class MyRestController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public MyRestController(UserService userService, RoleService roleService){
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/principal")
    public ResponseEntity<User> getPrincipal(Principal principal) {
        User user = userService.getByEmail(principal.getName());
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<User>> list(){
        List<User> all = userService.all();
        return new ResponseEntity<>(all, HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/new")
    public ResponseEntity<User> add(@RequestBody User user){
        userService.add(user);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @PutMapping(value = "/edit/{id}")
    public ResponseEntity<User> edit(@PathVariable int id, @RequestBody User user){
        userService.edit(user);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);

    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<User> delete(@PathVariable int id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "roles")
    public ResponseEntity<List<Role>> allRoles(){
        List<Role> roleList = roleService.allRoles();
        return new ResponseEntity<>(roleList, HttpStatus.ACCEPTED);
    }

}
