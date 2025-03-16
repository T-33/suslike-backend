package com.timoxa.ems_backend.mapper;

import com.timoxa.ems_backend.dto.UserDto;
import com.timoxa.ems_backend.entity.User;

public class UserMapper {

    private UserMapper(){}

    public static UserDto mapToEmployeeDto(User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getCreatedAt()
        );
    }

    public static User mapToEmployee(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getEmail(),
                userDto.getCreatedAt()
        );
    }
}
