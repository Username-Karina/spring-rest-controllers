package com.spring.boot.springrestcontrollers.service;

import com.spring.boot.springrestcontrollers.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService extends UserDetailsService {
    User getByEmail(String email);
    List<User> all();
    void add(User user);
    User get(int id);
    void delete(int id);
    void edit(User user);
    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
}
