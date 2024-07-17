package org.example.wypozyczalniamotocykli.service;

import org.example.wypozyczalniamotocykli.model.Motorcycle;
import org.example.wypozyczalniamotocykli.repository.MotorcycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotorcycleService {
    private final MotorcycleRepository motorcycleRepository;

    @Autowired
    public MotorcycleService(MotorcycleRepository motorcycleRepository){
        this.motorcycleRepository = motorcycleRepository;
    }

    public void saveMotorcycle(Motorcycle motorcycle) {
        motorcycleRepository.save(motorcycle);
    }

    public List<Motorcycle> getAllMotorcycles() {
        return motorcycleRepository.findAll();
    }

    public Optional<Motorcycle> findMotorcycleById(Long id) {
        return motorcycleRepository.findById(id);
    }

    public Motorcycle updateMotorcycle(Long id, Motorcycle motorcycleDetails) {
        Optional<Motorcycle> motorcycleOptional = motorcycleRepository.findById(id);
        if (motorcycleOptional.isPresent()){
            Motorcycle motorcycle = motorcycleOptional.get();
            motorcycle.setMarka(motorcycleDetails.getMarka());
            motorcycle.setModel(motorcycleDetails.getModel());
            motorcycle.setRocznik(motorcycleDetails.getRocznik());
            motorcycle.setPojemnosc(motorcycleDetails.getPojemnosc());
            motorcycle.setMoc(motorcycleDetails.getMoc());
            motorcycle.setCena(motorcycleDetails.getCena());
            motorcycle.setKolor(motorcycleDetails.getKolor());
            motorcycle.setImageLink(motorcycleDetails.getImageLink());

            motorcycleRepository.save(motorcycle);
            return motorcycle;
        }
        return null;
    }
    public ResponseEntity<?> deleteMotorcycle(Long id) {
        Optional<Motorcycle> motorcycleOptional = motorcycleRepository.findById(id);

        if (motorcycleOptional.isPresent()) {
            motorcycleRepository.delete(motorcycleOptional.get());
            return ResponseEntity.ok().build();
        } else {
            // it might be a good idea to also return proper HTTP status in case of failure
            return ResponseEntity.notFound().build();
        }
}}
