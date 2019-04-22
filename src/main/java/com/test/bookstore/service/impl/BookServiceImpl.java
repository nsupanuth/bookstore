package com.test.bookstore.service.impl;

import com.test.bookstore.model.Book;
import com.test.bookstore.repository.BookRepository;
import com.test.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        sortedByRecommendedThenName(books);
        return books;
    }

    private void sortedByRecommendedThenName(List<Book> books) {
        books.sort(comparing(Book::getRecommended, reverseOrder())
            .thenComparing(Book::getName));
    }

}
