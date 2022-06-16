package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;

public interface RoleDao {
    Role findByName(String role);
    List<Role> getAllRoles();
     void saveRole(Role role);
}
