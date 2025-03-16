package com.timoxa.ems_backend.service.impl;

import com.timoxa.ems_backend.dto.UserDto;
import com.timoxa.ems_backend.entity.User;
import com.timoxa.ems_backend.exception.ResourceNotFoundException;
import com.timoxa.ems_backend.mapper.UserMapper;
import com.timoxa.ems_backend.repository.UserRepository;
import com.timoxa.ems_backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        User user = UserMapper.mapToEmployee(userDto);
        User savedUser = userRepository.save(user);

        return UserMapper.mapToEmployeeDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with a given id does not exist " + userId));

        return UserMapper.mapToEmployeeDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream().map(UserMapper::mapToEmployeeDto).toList();
    }

    @Override
    public UserDto updateUser(Long userId, UserDto updatedUser) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with a given id does not exist " + userId));

        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());
        user.setEmail(updatedUser.getEmail());

        userRepository.save(user);

        return UserMapper.mapToEmployeeDto(user);
    }

    @Override
    public UserDto deleteUser(Long employeeId) {
        User user = userRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("User with a given id does not exist " + employeeId));

        userRepository.delete(user);

        return UserMapper.mapToEmployeeDto(user);
    }
}
