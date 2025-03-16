package com.timoxa.ems_backend.repository;

import com.timoxa.ems_backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Employee, Long> {

}
