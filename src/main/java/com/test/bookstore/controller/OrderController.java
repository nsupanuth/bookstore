package com.test.bookstore.controller;

import com.test.bookstore.model.Book;
import com.test.bookstore.model.User;
import com.test.bookstore.model.dto.OrderRequestDto;
import com.test.bookstore.repository.BookRepository;
import com.test.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/users/orders")
    public void order(@RequestBody OrderRequestDto orderRequestDto, Principal principal) {

        User user = userRepository.findByUsername(principal.getName());
        Optional<Book> bookOptional = bookRepository.findById(Long.valueOf(orderRequestDto.getOrders().get(0)));

        Book book = bookOptional.get();
        book.setUserOrders(user);

        bookRepository.save(book);
    }

}
