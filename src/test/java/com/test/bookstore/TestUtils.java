package com.test.bookstore;

import com.test.bookstore.model.Book;

import java.util.Arrays;
import java.util.List;

public class TestUtils {

    private static final String BOOK_FIRST_ORDER_NAME = "3Harry Potter2";

    private static final String BOOK_LAST_ORDER_NAME = "Harry Potter3";

    public  Book expectedBookFirstOrder() {
        Book book = new Book();
        book.setRecommended(true);
        book.setName(BOOK_FIRST_ORDER_NAME);
        return book;
    }

    public Book expectedBookLastOrder() {
        Book book = new Book();
        book.setRecommended(false);
        book.setName(BOOK_LAST_ORDER_NAME);
        return book;
    }

    public List<Book> generateBookList() {
        Book book = new Book();
        book.setName("BOOK_LAST_ORDER_NAME");
        book.setRecommended(true);

        return Arrays.asList(book, expectedBookLastOrder(), expectedBookFirstOrder());
    }



}
