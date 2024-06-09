package com.spring.boot.springrestcontrollers.service;

import com.spring.boot.springrestcontrollers.entity.Role;

import java.util.List;


public interface RoleService {
    List<Role> allRoles();
    void saveRole(Role role);
    Role findRoleById(int id);
}
