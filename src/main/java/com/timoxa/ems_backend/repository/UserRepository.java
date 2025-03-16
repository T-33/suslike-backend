package com.timoxa.ems_backend.repository;

import com.timoxa.ems_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
