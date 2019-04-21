package com.test.bookstore.service.impl;

import com.test.bookstore.common.exception.BadRequestAlertException;
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
        String username = userRequestDto.getUsername();
        String password = userRequestDto.getPassword();
        validateDuplicateUsername(username);

        userRequestDto.setPassword(getPasswordEncoder().encode(password));
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

    private void validateDuplicateUsername(String username) {
        User existingUser = userRepository.findByUsername(username);
        if (existingUser != null) {
            throw new BadRequestAlertException("Username is already exist", UserService.class.getName(), "usernameAlreadyExist");
        }
    }

    private PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
