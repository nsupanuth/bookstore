package com.test.bookstore.controller;

import com.test.bookstore.model.Book;
import com.test.bookstore.model.User;
import com.test.bookstore.repository.BookRepository;
import com.test.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/books")
    public List<Book> getBooks(Principal principal) {
        String username = principal.getName();
        System.out.println(username);
//        Book book = new Book();
//        book.setAuthor("Supanuth");
//        book.setName("Harry Potter");
//        book.setRecommended(true);
//
//        bookRepository.save(book);

        return bookRepository.findAll();
    }

    @GetMapping("/order")
    public String orderBook() {
        Optional<User> userOptional = userRepository.findById(1L);
        Optional<Book> bookOptional = bookRepository.findById(1L);

        Book book = bookOptional.get();
        book.setUserOrders(userOptional.get());

        bookRepository.save(book);

        Optional<Book> bookOptional1 = bookRepository.findById(2L);
        Book book2 = bookOptional1.get();
        book2.setUserOrders(userOptional.get());

        bookRepository.save(book2);


        return "Success";
    }


}
