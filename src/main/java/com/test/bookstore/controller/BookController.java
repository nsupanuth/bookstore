package com.test.bookstore.controller;

import com.test.bookstore.mapper.BookMapper;
import com.test.bookstore.model.Book;
import com.test.bookstore.model.dto.BookDto;
import com.test.bookstore.model.dto.BookResponseDto;
import com.test.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper bookMapper;

    @GetMapping("/books")
    public BookResponseDto getBooks() {
        List<Book> bookList = bookService.getAllBooks();
        List<BookDto> bookDtoList = bookMapper.toDto(bookList);
        return new BookResponseDto(bookDtoList);
    }

}
