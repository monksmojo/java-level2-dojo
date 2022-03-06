package com.practice.javawebservice.Repository;

import com.practice.javawebservice.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts,Long> {
}
