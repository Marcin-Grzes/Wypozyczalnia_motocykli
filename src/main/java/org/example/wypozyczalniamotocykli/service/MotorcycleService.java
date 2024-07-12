package org.example.wypozyczalniamotocykli.service;

import org.example.wypozyczalniamotocykli.model.Motorcycle;
import org.example.wypozyczalniamotocykli.repository.MotorcycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MotorcycleService {
    private final MotorcycleRepository motorcycleRepository;

    @Autowired
    public MotorcycleService(MotorcycleRepository motorcycleRepository){
        this.motorcycleRepository = motorcycleRepository;
    }

    public Motorcycle createMotorcycle() {
        Motorcycle motorcycle = new Motorcycle();
        motorcycle.setMarka("Yamaha");
        motorcycle.setModel("R1");
        motorcycle.setKolor("niebieski");
        motorcycle.setPojemnosc(1000);
        motorcycle.setMoc(200);
        motorcycle.setRocznik(2024);
        motorcycle.setCena(new BigDecimal(300));
        motorcycle.setImageLink("static/images_bike/Yamaha_R1_blue_2024.jpg");
        return motorcycleRepository.save(motorcycle);
    }
/*    public Motorcycle saveMotorcycle(Motorcycle motorcycle) {
        return motorcycleRepository.save(motorcycle);
    }*/

    public List<Motorcycle> getAllMotorcycles() {
        return motorcycleRepository.findAll();
    }
}
