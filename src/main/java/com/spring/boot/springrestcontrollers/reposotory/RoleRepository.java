package com.spring.boot.springrestcontrollers.reposotory;

import com.spring.boot.springrestcontrollers.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
