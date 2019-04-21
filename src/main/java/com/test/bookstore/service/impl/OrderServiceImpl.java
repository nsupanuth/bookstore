package com.test.bookstore.service.impl;

import com.test.bookstore.model.Book;
import com.test.bookstore.model.User;
import com.test.bookstore.model.dto.OrderResponseDto;
import com.test.bookstore.repository.BookRepository;
import com.test.bookstore.repository.UserRepository;
import com.test.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public OrderResponseDto orderBooks(List<Integer> orderList, String username) {

        Double totalPrice = 0d;
        User user = userRepository.findByUsername(username);

        for (Integer i: orderList) {
            Optional<Book> bookOptional = bookRepository.findById(Long.valueOf(i));

            Book book = bookOptional.get();
            book.setUserOrders(user);
            bookRepository.save(book);
            totalPrice += book.getPrice();
        }

        return new OrderResponseDto(totalPrice);
    }

}
