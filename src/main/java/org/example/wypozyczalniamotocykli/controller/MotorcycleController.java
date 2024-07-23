package org.example.wypozyczalniamotocykli.controller;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.wypozyczalniamotocykli.model.Motorcycle;
import org.example.wypozyczalniamotocykli.service.MotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import java.io.Serializable;
import java.util.List;


@Component
@Scope("session")
@AllArgsConstructor
@NoArgsConstructor
public class MotorcycleController implements Serializable {
    private MotorcycleService motorcycleService;


    @Autowired
    public MotorcycleController(MotorcycleService motorcycleService) {
        this.motorcycleService = motorcycleService;
    }

    @Getter
    @Setter
    private Motorcycle newMotorcycle = new Motorcycle();


    public List<Motorcycle> getMotorcycles() {
        return motorcycleService.getAllMotorcycles();
    }


    public void addMotorcycle() {
        motorcycleService.saveMotorcycle(newMotorcycle);
        newMotorcycle = new Motorcycle();
    }
}
