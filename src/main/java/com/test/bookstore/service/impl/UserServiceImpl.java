package com.test.bookstore.service.impl;

import com.test.bookstore.mapper.UserMapper;
import com.test.bookstore.model.User;
import com.test.bookstore.model.dto.UserRequestDto;
import com.test.bookstore.repository.UserRepository;
import com.test.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addNewUser(UserRequestDto userRequestDto) {
        userRequestDto.setPassword(getPasswordEncoder().encode(userRequestDto.getPassword()));
        User user = userMapper.fromUserRequestDto(userRequestDto);
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserByUsername(String username) {
        User deletedUser = userRepository.findByUsername(username);
        userRepository.delete(deletedUser);
    }

    private PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
