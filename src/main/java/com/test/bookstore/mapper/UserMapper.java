package com.test.bookstore.mapper;

import com.test.bookstore.model.User;
import com.test.bookstore.model.dto.UserDto;
import com.test.bookstore.model.dto.UserRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
        @Mapping(source = "name", target = "name"),
        @Mapping(source = "surname", target = "surname"),
        @Mapping(source = "dateOfBirth", target = "date_of_birth", qualifiedByName = "mapDateToString")
    })
    UserDto toDto(User user);

    List<UserDto> toDto(List<User> users);

    @Mappings({
        @Mapping(source = "date_of_birth", target = "dateOfBirth", qualifiedByName = "mapStringToDate")
    })
    User fromUserRequestDto(UserRequestDto userRequestDto);

    @Named("mapStringToDate")
    default Date mapStringToDate(String dateString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse(dateString);
        return date;
    }

    @Named("mapDateToString")
    default String mapDateToString(Date date) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }

}
