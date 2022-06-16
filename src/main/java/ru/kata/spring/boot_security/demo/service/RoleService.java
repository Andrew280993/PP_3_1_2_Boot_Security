package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;

public interface RoleService {
    Role findByName(String role);
    List<Role> getAllRoles();
    void saveRole(Role role);
}