package com.practice.javawebservice.Repository;

import com.practice.javawebservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
