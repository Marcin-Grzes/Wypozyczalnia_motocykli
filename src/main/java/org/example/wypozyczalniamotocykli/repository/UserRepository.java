package org.example.wypozyczalniamotocykli.repository;

import org.example.wypozyczalniamotocykli.model.User_app;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User_app, Long> {
    User_app findByUsername(String username);
}