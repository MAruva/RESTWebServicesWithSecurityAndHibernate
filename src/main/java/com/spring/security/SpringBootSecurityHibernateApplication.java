package com.spring.security;

import com.spring.security.model.Role;
import com.spring.security.model.User;
import com.spring.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class SpringBootSecurityHibernateApplication {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init(){
        User user = new User(
                "Memory",
                "Not Found",
                "codingisfun@maruva.com",
                passwordEncoder.encode("password"),
                Arrays.asList(
                        new Role("GUEST"),
                        new Role("ADMIN")));

        if (userRepository.findByEmail(user.getEmail()) == null){
            userRepository.save(user);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityHibernateApplication.class, args);
    }
}
