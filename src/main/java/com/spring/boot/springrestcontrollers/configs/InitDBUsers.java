package com.spring.boot.springrestcontrollers.configs;


import com.spring.boot.springrestcontrollers.entity.Role;
import com.spring.boot.springrestcontrollers.entity.User;
import com.spring.boot.springrestcontrollers.service.RoleService;
import com.spring.boot.springrestcontrollers.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitDBUsers {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public InitDBUsers(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void initApiUserData() {

        Role roleAdmin = new Role(1,"ROLE_ADMIN");
        Role roleUser = new Role(2,"ROLE_USER");

        roleService.saveRole(roleAdmin);
        roleService.saveRole(roleUser);

        Set<Role> rolesForAdmin = new HashSet<>();
        Set<Role> rolesForUser = new HashSet<>();

        rolesForAdmin.add(roleService.findRoleById(1));
        rolesForAdmin.add(roleService.findRoleById(2));

        rolesForUser.add(roleService.findRoleById(2));

        User user1 = new User(1,"admin","admin",18,"admin@mail.ru","admin");
        user1.setRoles(rolesForAdmin);

        User user2 = new User(2,"user","user",18,"user@mail.ru","user");
        user2.setRoles(rolesForUser);

        userService.add(user1);
        userService.add(user2);
    }
}
