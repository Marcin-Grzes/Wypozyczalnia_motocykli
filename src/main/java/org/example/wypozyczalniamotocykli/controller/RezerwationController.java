package org.example.wypozyczalniamotocykli.controller;

import lombok.*;
import org.example.wypozyczalniamotocykli.model.Rezerwation;
import org.example.wypozyczalniamotocykli.service.RezerwationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Scope("session")
@AllArgsConstructor

public class RezerwationController implements Serializable {
    private final RezerwationService rezerwationService;

    @Autowired
    public RezerwationController(RezerwationService rezerwationService) {
        this.rezerwationService = rezerwationService;
    }

    @Getter
    @Setter
    private Rezerwation newRezerwation = new Rezerwation();

    public String rezerwation() {
        return "/rezerwation";
    }

    public String addRezerwation() {
        rezerwationService.saveRezerwation(newRezerwation);
        newRezerwation = new Rezerwation();
        return "/rezerwation";
    }
}
