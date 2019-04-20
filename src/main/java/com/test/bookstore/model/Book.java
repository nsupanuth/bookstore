package com.test.bookstore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BOOK_TBL")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String author;

    private Double price;

    private Boolean isRecommended;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    private User userOrders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getRecommended() {
        return isRecommended;
    }

    public void setRecommended(Boolean recommended) {
        isRecommended = recommended;
    }

    public User getUserOrders() {
        return userOrders;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setUserOrders(User userOrders) {
        List<Book> books;
        books = userOrders.getBooks() == null ? new ArrayList<>() : userOrders.getBooks();
        books.add(this);
        userOrders.setBooks(books);
        this.userOrders = userOrders;
    }

}
