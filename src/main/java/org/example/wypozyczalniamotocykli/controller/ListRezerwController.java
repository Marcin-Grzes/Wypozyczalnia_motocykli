package org.example.wypozyczalniamotocykli.controller;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.wypozyczalniamotocykli.model.Rezerwation;
import org.example.wypozyczalniamotocykli.model.User_app;
import org.example.wypozyczalniamotocykli.service.RezerwationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Scope("session")
@AllArgsConstructor
@Getter
@Setter
public class ListRezerwController {
    private RezerwationService rezerwationService;
    private User_app currentUser;
    private HttpSession httpSession;

    @Autowired
    public ListRezerwController(RezerwationService rezerwationService, HttpSession httpSession) {
        this.rezerwationService = rezerwationService;
        this.httpSession = httpSession;
    }
    public List<Rezerwation> getCurrentUserRezerwations() {
        User_app currentUser = (User_app) httpSession.getAttribute("user");
        this.currentUser = currentUser;
        return rezerwationService.findRezerwationsByUser(currentUser);
    }
}
