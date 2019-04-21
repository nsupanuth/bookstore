package com.test.bookstore.controller;

import com.test.bookstore.model.dto.OrderRequestDto;
import com.test.bookstore.model.dto.OrderResponseDto;
import com.test.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.POST, value = "/users/orders")
    public OrderResponseDto order(@RequestBody OrderRequestDto orderRequestDto, Principal principal) {
        return orderService.orderBooks(orderRequestDto.getOrders(), principal.getName());
    }

}
