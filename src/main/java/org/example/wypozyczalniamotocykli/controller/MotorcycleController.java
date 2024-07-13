package org.example.wypozyczalniamotocykli.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.wypozyczalniamotocykli.model.Motorcycle;
import org.example.wypozyczalniamotocykli.service.MotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


import java.io.Serializable;
import java.util.List;

@Component
@Scope("session")
@AllArgsConstructor
@NoArgsConstructor // Tworzymy także konstruktor bezargumentowy, aby umożliwić utworzenie nowego obiektu Motorcycle
public class MotorcycleController implements Serializable {
    private  MotorcycleService motorcycleService;

    @Autowired
    public MotorcycleController(MotorcycleService motorcycleService) {
        this.motorcycleService = motorcycleService;
    }
    // Create a new instance of Motorcycle for the form to bind to
    @Getter
    @Setter
    private Motorcycle newMotorcycle = new Motorcycle();


    @GetMapping("motorcycles")
    public List<Motorcycle> getMotorcycles() {
        return motorcycleService.getAllMotorcycles();
    }

    @PostMapping("/motorcycles")
    public void addMotorcycle() {
        motorcycleService.saveMotorcycle(newMotorcycle);
        newMotorcycle = new Motorcycle();
    }

    @PutMapping("/motorcycles/{id}")
    public Motorcycle updateMotorcycle(@PathVariable(value = "id") Long motorcycleId,
                                       @Valid @RequestBody Motorcycle motorcycleDetails) {
        return motorcycleService.updateMotorcycle(motorcycleId, motorcycleDetails);
    }

    @DeleteMapping("/motorcycles/{id}")
    public ResponseEntity<?> deleteMotorcycle(@PathVariable(value = "id") Long motorcycleId) {
        return motorcycleService.deleteMotorcycle(motorcycleId);
    }
}


/*
    public List<Motorcycle> getMotorcycles() {
        return motorcycleService.getAllMotorcycles();
    }
    // When the form is submitted, this method get's called
    public void addMotorcycle() {
        motorcycleService.saveMotorcycle(newMotorcycle);
        newMotorcycle = new Motorcycle();
    }
}*/
