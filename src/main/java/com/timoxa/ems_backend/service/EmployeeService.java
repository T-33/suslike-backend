package com.timoxa.ems_backend.service;

import com.timoxa.ems_backend.dto.EmployeeDto;
import com.timoxa.ems_backend.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);

    EmployeeDto deleteEmployee(Long employeeId);
}
