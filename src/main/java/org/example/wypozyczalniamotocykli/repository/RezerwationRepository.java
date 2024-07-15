package org.example.wypozyczalniamotocykli.repository;

import org.example.wypozyczalniamotocykli.model.Rezerwation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RezerwationRepository extends JpaRepository<Rezerwation, Long> {
}
