package com.example.youreviews.repositories;

import com.example.youreviews.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;


@RestController
public interface UserRepository extends JpaRepository<User,Long> {
}
