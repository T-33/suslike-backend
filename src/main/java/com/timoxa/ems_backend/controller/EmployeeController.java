package com.timoxa.ems_backend.controller;

import com.timoxa.ems_backend.dto.UserDto;
import com.timoxa.ems_backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final UserService userService;

    public EmployeeController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> createEmployee(@RequestBody UserDto userDto) {
        UserDto savedEmployee = userService.createUser(userDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        UserDto userDto = userService.getUserById(employeeId);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllEmployees() {
        List<UserDto> employees = userService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody UserDto updatedEmployee) {
        UserDto userDto = userService.updateUser(employeeId, updatedEmployee);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<UserDto> deleteEmployee(@PathVariable("id") Long employeeId) {
        UserDto userDto = userService.deleteUser(employeeId);

        return ResponseEntity.ok(userDto);
    }
}
