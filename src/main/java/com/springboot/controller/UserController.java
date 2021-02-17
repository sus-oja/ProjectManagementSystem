package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.springboot.entity.User;
import com.springboot.repository.UserRepository;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public String addUser(@RequestParam String first, @RequestParam String last) {
        User user = new User();
        user.setFirstname(first);
        user.setLastname(last);
        userRepository.save(user);
        return "Added new user to db!";
    }

    @GetMapping("/list")
    public Iterable<User> getUser() {
        return userRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public User findUserBy(@PathVariable Integer id) {
        return userRepository.findUserBy(id);
    }
}
