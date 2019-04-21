package com.test.bookstore.service;

import com.test.bookstore.model.User;
import com.test.bookstore.model.dto.UserRequestDto;

import java.util.List;

public interface UserService {

    void addNewUser(UserRequestDto userRequestDto);

    List<User> getAllUsers();

}
