package com.test.bookstore.controller;

import com.test.bookstore.mapper.UserMapper;
import com.test.bookstore.model.User;
import com.test.bookstore.model.dto.UserDto;
import com.test.bookstore.model.dto.UserRequestDto;
import com.test.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping(path = "/users")
    public void registerNewUser(@RequestBody UserRequestDto userRequestDto) {
        userService.addNewUser(userRequestDto);
    }

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        List<User> users = userService.getAllUsers();
        return userMapper.toDto(users);
    }

}
