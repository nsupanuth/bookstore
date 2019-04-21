package com.test.bookstore.model.dto;

import java.util.List;

public class UserDto {

    private String name;
    private String surname;
    private String date_of_birth;
    private List<Integer> books_test;

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

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public List<Integer> getBooks_test() {
        return books_test;
    }

    public void setBooks_test(List<Integer> books_test) {
        this.books_test = books_test;
    }
}
