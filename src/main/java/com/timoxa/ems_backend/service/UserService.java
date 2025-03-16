package com.timoxa.ems_backend.service;

import com.timoxa.ems_backend.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long employeeId);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long employeeId, UserDto updatedEmployee);

    UserDto deleteUser(Long employeeId);
}
