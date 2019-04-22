package com.test.bookstore.model.dto;

import com.test.bookstore.common.constant.RegxPatternConstants;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserRequestDto {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @Pattern(regexp = RegxPatternConstants.DATE_DD_MM_YY)
    private String date_of_birth;
    private String name;
    private String surname;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
