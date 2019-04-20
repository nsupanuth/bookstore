package com.test.bookstore.mapper;

import com.test.bookstore.model.User;
import com.test.bookstore.model.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
        @Mapping(source = "name", target = "name"),
        @Mapping(source = "surname", target = "surname")
    })
    UserDto toDto(User user);

    List<UserDto> toDto(List<User> users);
}
