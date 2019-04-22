package com.test.bookstore.service.impl;

import com.test.bookstore.TestUtils;
import com.test.bookstore.model.Book;
import com.test.bookstore.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceImplTest extends TestUtils{

    @InjectMocks
    private BookServiceImpl bookService;

    @Mock
    private BookRepository bookRepository;

    private List<Book> bookList;

    @Before
    public void setUp() {
        bookList = generateBookList();
    }

    @Test
    public void getAllBooksShouldVerifyDependenciesCorrectly() {

        when(bookRepository.findAll()).thenReturn(bookList);

        List<Book> result = bookService.getAllBooks();

        verify(bookRepository, times(1)).findAll();
        assertEquals(bookList, result);

    }

    @Test
    public void getAllBooksShouldBeSortedCorrectly() {

        when(bookRepository.findAll()).thenReturn(bookList);

        List<Book> result = bookService.getAllBooks();

        String firstOrderBookName = result.get(0).getName();
        boolean firstOrderRecommended = result.get(0).getRecommended();

        String lastOrderBookName = result.get(result.size()-1).getName();
        boolean lastOrderRecommended = result.get(result.size()-1).getRecommended();

        assertEquals(expectedBookFirstOrder().getName(), firstOrderBookName);
        assertTrue(firstOrderRecommended);

        assertEquals(expectedBookLastOrder().getName(), lastOrderBookName);
        assertFalse(lastOrderRecommended);

    }

}
