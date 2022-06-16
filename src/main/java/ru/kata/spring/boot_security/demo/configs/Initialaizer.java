package ru.kata.spring.boot_security.demo.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;


@Component
public class Initialaizer {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public Initialaizer(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void NewUsers() {

        Role role1 = new Role("ADMIN");
        Role role2 = new Role("USER");
        roleService.saveRole(role1);
        roleService.saveRole(role2);

        User user = new User();
        user.setUsername("George");
        user.setLastName("Michael");
        user.setAge((byte) 22);
        user.setPassword("100");
        user.addRole(role1);


        User user2 = new User();
        user2.setUsername("Lady");
        user2.setLastName("Gaga");
        user2.setAge((byte) 32);
        user2.setPassword("100");
        user2.addRole(role2);

        User user3 = new User();
        user3.setUsername("Marty");
        user3.setLastName("McFly");
        user3.setAge((byte) 21);
        user3.setPassword("100");
        user3.addRole(role2);
        user3.addRole(role1);


        userService.saveUser(user);
        userService.saveUser(user2);
        userService.saveUser(user3);

    }
}
