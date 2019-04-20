package com.test.bookstore.repository;

import com.test.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

    List<Book> findAllByOrderByIsRecommendedDesc();
}
