package com.test.bookstore.service.impl;

import com.test.bookstore.common.exception.BadRequestAlertException;
import com.test.bookstore.model.Book;
import com.test.bookstore.model.User;
import com.test.bookstore.model.dto.OrderResponseDto;
import com.test.bookstore.repository.BookRepository;
import com.test.bookstore.repository.UserRepository;
import com.test.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public OrderResponseDto orderBooks(List<Integer> orderList, String username) {

        orderList = orderList.stream().distinct().collect(Collectors.toList());

        Double totalPrice = 0d;
        User user = userRepository.findByUsername(username);

        validateDuplicateOrderList(orderList, user);

        for (Integer i: orderList) {

            Optional<Book> bookOptional = bookRepository.findById(Long.valueOf(i));

            if (bookOptional.isPresent()) {
                Book book = bookOptional.get();
                book.setUserOrders(user);
                bookRepository.save(book);
                totalPrice += book.getPrice();
            } else {
                throw new BadRequestAlertException("The order is not exist", OrderServiceImpl.class.getName(), "notExistsOrder");
            }

        }

        return new OrderResponseDto(totalPrice);
    }

    private void validateDuplicateOrderList(List<Integer> orderList, User user) {
        Set<Integer> setItemNo = new HashSet<>();
        user.getBooks().forEach(book -> setItemNo.add(book.getId().intValue()));
        orderList.stream().filter(bookId -> !setItemNo.add(bookId)).forEach(bookId -> {
            throw new BadRequestAlertException("You already ordered this book", OrderServiceImpl.class.getName(), "duplicate");
        });
    }

}
