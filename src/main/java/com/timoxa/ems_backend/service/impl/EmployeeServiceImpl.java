package com.timoxa.ems_backend.service.impl;

import com.timoxa.ems_backend.dto.EmployeeDto;
import com.timoxa.ems_backend.entity.Employee;
import com.timoxa.ems_backend.exception.ResourceNotFoundException;
import com.timoxa.ems_backend.mapper.EmployeeMapper;
import com.timoxa.ems_backend.repository.UserRepository;
import com.timoxa.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private UserRepository userRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = userRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = userRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with a given id does not exist " + employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = userRepository.findAll();

        return employees.stream().map(EmployeeMapper::mapToEmployeeDto).toList();
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee = userRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with a given id does not exist " + employeeId));

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        userRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public EmployeeDto deleteEmployee(Long employeeId) {
        Employee employee = userRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with a given id does not exist " + employeeId));

        userRepository.delete(employee);

        return EmployeeMapper.mapToEmployeeDto(employee);
    }
}
