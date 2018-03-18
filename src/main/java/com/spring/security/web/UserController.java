package com.spring.security.web;

import com.spring.security.model.User;
import com.spring.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/all")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/{firstName}/{lastName}")
    public User getUser(@PathVariable String firstName, @PathVariable String lastName) {
        User user = userRepository.findByFirstAndLastName(firstName, lastName);
        if (user != null) {
            return user;
        }
        return null;
    }

}
