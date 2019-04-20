package com.test.bookstore.mapper;

import com.test.bookstore.model.Book;
import com.test.bookstore.model.dto.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mappings({
        @Mapping(source = "recommended", target = "is_recommended")
    })
    BookDto toDto(Book book);

    List<BookDto> toDto(List<Book> books);

}
