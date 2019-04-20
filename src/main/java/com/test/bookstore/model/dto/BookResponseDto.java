package com.test.bookstore.model.dto;

import java.util.List;

public class BookResponseDto {

    private List<BookDto> books;

    public BookResponseDto() {}

    public BookResponseDto(List<BookDto> books) {
        this.books = books;
    }

    public List<BookDto> getBooks() {
        return books;
    }

    public void setBooks(List<BookDto> books) {
        this.books = books;
    }

}
