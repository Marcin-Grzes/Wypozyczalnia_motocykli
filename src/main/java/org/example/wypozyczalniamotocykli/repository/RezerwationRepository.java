package org.example.wypozyczalniamotocykli.repository;

import org.example.wypozyczalniamotocykli.model.Rezerwation;
import org.example.wypozyczalniamotocykli.model.User_app;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RezerwationRepository extends JpaRepository<Rezerwation, Long> {
    List<Rezerwation> findByUser(User_app user);
}
