package com.test.bookstore.model.dto;

public class OrderResponseDto {

    private Double price;

    public OrderResponseDto(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
