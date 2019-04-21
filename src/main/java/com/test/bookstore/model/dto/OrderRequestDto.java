package com.test.bookstore.model.dto;

import java.util.List;

public class OrderRequestDto {

    private List<Integer> orders;

    public List<Integer> getOrders() {
        return orders;
    }

    public void setOrders(List<Integer> orders) {
        this.orders = orders;
    }
}
