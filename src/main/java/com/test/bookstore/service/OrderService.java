package com.test.bookstore.service;

import com.test.bookstore.model.dto.OrderResponseDto;

import java.util.List;

public interface OrderService {

    OrderResponseDto orderBooks(List<Integer> orderList, String username);

}
