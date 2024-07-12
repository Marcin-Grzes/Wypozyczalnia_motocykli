package org.example.wypozyczalniamotocykli.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.wypozyczalniamotocykli.model.Motorcycle;
import org.example.wypozyczalniamotocykli.service.MotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

//import java.util.List;
//@RequestMapping("/motorcycle")
//@RestController
//public class MotorcycleController {private final MotorcycleService motorcycleService;
//
//    @Autowired
//    public MotorcycleController(MotorcycleService motorcycleService) {
//        this.motorcycleService = motorcycleService;
//    }
//
///*    @PostMapping("/create")
//    public Motorcycle createMotorcycle() {
//        return motorcycleService.createMotorcycle();*/
//    }
///*    @PostMapping
//    public ResponseEntity<Motorcycle> addMotorcycle(@RequestBody Motorcycle motorcycle) {
//        Motorcycle savedMotorcycle = motorcycleService.saveMotorcycle(motorcycle);
//        return new ResponseEntity<>(savedMotorcycle, HttpStatus.CREATED);
//    }*/
//
//    @GetMapping
//    public List<Motorcycle> getAllMotorcycles() {
//        return motorcycleService.getAllMotorcycles();
//    }
//}

@Component
@Scope("session")
@AllArgsConstructor
@NoArgsConstructor // Tworzymy także konstruktor bezargumentowy, aby umożliwić utworzenie nowego obiektu Motorcycle
public class MotorcycleController implements Serializable {
    private  MotorcycleService motorcycleService;


    // Create a new instance of Motorcycle for the form to bind to
    @Getter
    @Setter
    private Motorcycle newMotorcycle = new Motorcycle();

    @Autowired
    public MotorcycleController(MotorcycleService motorcycleService) {
        this.motorcycleService = motorcycleService;
    }

    public List<Motorcycle> getMotorcycles() {
        return motorcycleService.getAllMotorcycles();
    }
    // When the form is submitted, this method get's called
    public void addMotorcycle() {
        motorcycleService.saveMotorcycle(newMotorcycle);
        newMotorcycle = new Motorcycle();
    }
}