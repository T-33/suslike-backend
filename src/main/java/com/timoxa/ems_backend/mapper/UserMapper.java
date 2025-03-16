package com.timoxa.ems_backend.mapper;

import com.timoxa.ems_backend.dto.UserDto;
import com.timoxa.ems_backend.entity.User;

public class EmployeeMapper {

    private EmployeeMapper(){}

    public static UserDto mapToEmployeeDto(User user) {
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }

    public static User mapToEmployee(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
    }
}
