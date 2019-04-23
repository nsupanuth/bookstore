package com.test.bookstore.controller;

import com.test.bookstore.mapper.UserMapper;
import com.test.bookstore.model.User;
import com.test.bookstore.model.dto.UserDto;
import com.test.bookstore.model.dto.UserRequestDto;
import com.test.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public void registerNewUser(@Valid @RequestBody UserRequestDto userRequestDto) {
        userService.addNewUser(userRequestDto);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<UserDto> getUsers() {
        List<User> users = userService.getAllUsers();
        return userMapper.toDto(users);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users")
    public void deleteCurrentUser(Principal principal) {
        String username = principal.getName();
        userService.deleteUserByUsername(username);
    }

}
