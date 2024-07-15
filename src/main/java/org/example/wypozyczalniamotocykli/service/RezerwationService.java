package org.example.wypozyczalniamotocykli.service;

import org.example.wypozyczalniamotocykli.model.Rezerwation;
import org.example.wypozyczalniamotocykli.repository.RezerwationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RezerwationService {
    private final RezerwationRepository rezerwationRepository;

    @Autowired
    public RezerwationService(RezerwationRepository rezerwationRepository){
        this.rezerwationRepository = rezerwationRepository;
    }

    public void saveRezerwation(Rezerwation rezerwation) {
        rezerwationRepository.save(rezerwation);
    }

    public List<Rezerwation> getAllRezerwations() {
        return rezerwationRepository.findAll();
    }
}
