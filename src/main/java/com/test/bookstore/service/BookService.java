package com.test.bookstore.service;

import com.test.bookstore.model.Book;
import com.test.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;

@Service
public class BookService {

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
