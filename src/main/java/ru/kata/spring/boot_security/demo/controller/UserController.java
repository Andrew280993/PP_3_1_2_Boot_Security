package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.User;


import java.security.Principal;


@RestController
public class UserController {

    private final UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
            this.userDao = userDao;
        }

        @GetMapping("/user")
        public String daoTestPage(Principal principal) {
            User user = userDao.findByUsername(principal.getName());
            return "Authenticated user info: Id: " + user.getId()
                    + " Name: " + user.getUsername()
                    + " Lastname : " + user.getLastName()
                    + " Password : " + user.getPassword()
                    + " Age : " + user.getAge();
        }
}