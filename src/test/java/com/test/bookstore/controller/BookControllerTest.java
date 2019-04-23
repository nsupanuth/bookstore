package com.test.bookstore.controller;

import com.test.bookstore.TestUtils;
import com.test.bookstore.common.exception.ExceptionTranslator;
import com.test.bookstore.mapper.BookMapper;
import com.test.bookstore.model.Book;
import com.test.bookstore.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest extends TestUtils {

    private MockMvc mockMvc;

    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;

    @Mock
    private BookMapper bookMapper;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(bookController)
            .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
            .setControllerAdvice(new ExceptionTranslator()).build();
    }

    @Test
    public void getBooksShouldReturnStatus200Ok() throws Exception {

        List<Book> bookList = generateBookList();
        when(bookService.getAllBooks()).thenReturn(bookList);
        when(bookMapper.toDto(bookList)).thenReturn(mapBookToBookDto(bookList));

        this.mockMvc.perform(get("/books"))
            .andExpect(status().isOk());

    }




}
