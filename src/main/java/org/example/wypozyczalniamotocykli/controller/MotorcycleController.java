package org.example.wypozyczalniamotocykli.controller;

import org.example.wypozyczalniamotocykli.model.Motorcycle;
import org.example.wypozyczalniamotocykli.service.MotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/motorcycle")
@RestController
public class MotorcycleController {private final MotorcycleService motorcycleService;

    @Autowired
    public MotorcycleController(MotorcycleService motorcycleService) {
        this.motorcycleService = motorcycleService;
    }

    @PostMapping("/create")
    public Motorcycle createMotorcycle() {
        return motorcycleService.createMotorcycle();
    }
/*    @PostMapping
    public ResponseEntity<Motorcycle> addMotorcycle(@RequestBody Motorcycle motorcycle) {
        Motorcycle savedMotorcycle = motorcycleService.saveMotorcycle(motorcycle);
        return new ResponseEntity<>(savedMotorcycle, HttpStatus.CREATED);
    }*/

    @GetMapping
    public List<Motorcycle> getAllMotorcycles() {
        return motorcycleService.getAllMotorcycles();
    }
}
