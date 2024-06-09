//package com.spring.boot.springrestcontrollers.controllers;
//
//import com.spring.boot.springbootstrap.entity.User;
//import com.spring.boot.springbootstrap.service.RoleService;
//import com.spring.boot.springbootstrap.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.security.Principal;
//
//@Controller
//@RequestMapping( value = "/admin")
//public class AdminController {
//
//    private UserService userService;
//    private RoleService roleService;
//
//    @Autowired
//    public AdminController(UserService userService, RoleService roleService){
//        this.userService = userService;
//        this.roleService = roleService;
//    }
//
//    @GetMapping(value = "")
//    public String admin(Model model, Principal principal) {
//        model.addAttribute("user", userService.getByEmail(principal.getName()));
//        model.addAttribute("all", userService.all());
//        model.addAttribute("allRoles", roleService.allRoles());
//        return "admin";
//    }
//
//    @PostMapping(value = "/new")
//    public String add(User user){
//        userService.add(user);
//        return "redirect:/admin";
//    }
//
//    @PostMapping(value = "/{id}/edit")
//    public String edit(@ModelAttribute("user") User user){
//        userService.edit(user);
//        return "redirect:/admin";
//    }
//
//    @PostMapping(value = "/{id}/delete")
//    public String delete(@PathVariable("id") int id) {
//        userService.delete(id);
//        return "redirect:/admin";
//    }
//
//}
