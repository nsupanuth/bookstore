package com.test.bookstore.controller;

import com.test.bookstore.mapper.UserMapper;
import com.test.bookstore.model.User;
import com.test.bookstore.model.dto.UserDto;
import com.test.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @PostMapping(path = "/users")
    public void registerNewUser(@RequestBody User user) {
        user.setPassword(getPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
    }

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.toDto(users);
    }



}
