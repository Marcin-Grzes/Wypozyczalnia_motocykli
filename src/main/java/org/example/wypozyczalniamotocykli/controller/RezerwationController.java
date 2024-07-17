package org.example.wypozyczalniamotocykli.controller;

import jakarta.inject.Inject;
import jakarta.servlet.http.HttpSession;
import org.example.wypozyczalniamotocykli.model.User_app;
import org.example.wypozyczalniamotocykli.repository.MotorcycleRepository;
import jakarta.annotation.ManagedBean;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import lombok.*;
import org.example.wypozyczalniamotocykli.model.Motorcycle;
import org.example.wypozyczalniamotocykli.model.Rezerwation;
import org.example.wypozyczalniamotocykli.service.MotorcycleService;
import org.example.wypozyczalniamotocykli.service.RezerwationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.io.Serializable;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import jakarta.servlet.http.HttpSession;
import java.time.temporal.ChronoUnit;
import java.math.BigDecimal;

@Component
@Scope("session")
@AllArgsConstructor
@Getter @Setter
public class RezerwationController {
    private final RezerwationService rezerwationService;
    private final MotorcycleService motorcycleService;
    private String selectedMotorcycleId;
    private Motorcycle selectedMotorcycle;
    private Rezerwation newRezerwation = new Rezerwation();
    private User_app currentUser;
    private final HttpSession httpSession;
    private BigDecimal totalCost;

    @Autowired
    public RezerwationController(RezerwationService rezerwationService, MotorcycleService motorcycleService, HttpSession httpSession ) {
        this.rezerwationService = rezerwationService;
        this.motorcycleService = motorcycleService;
        this.httpSession = httpSession;
    }

    @PostConstruct
    public String rezerwation() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        this.selectedMotorcycleId = facesContext.getExternalContext().getRequestParameterMap().get("selectedMotorcycleId");
        System.out.println("selectedMotorcycleId: " + selectedMotorcycleId);

        Long motorcycleId = Long.valueOf(selectedMotorcycleId);
        Optional<Motorcycle> motorcycleOpt = motorcycleService.findMotorcycleById(motorcycleId);
        Motorcycle foundMotorcycle = motorcycleOpt.orElse(null);
        if (foundMotorcycle != null) {
            //Ustawiamy znaleziony motocykl jako wybrany motocykl
            this.selectedMotorcycle = foundMotorcycle;
        } else {
            System.out.println("Nie znaleziono motocykla o ID " + motorcycleId);
            //Czyścić selectedMotorcycle, jeśli nie znaleziono żadnego motocykla o danym ID
            this.selectedMotorcycle = null;
        }
        System.out.println(selectedMotorcycle);

        User_app currentUser = (User_app) httpSession.getAttribute("user");
        this.currentUser = currentUser;
        // load data on page start
        System.out.println("User object loaded from database: " + currentUser);


        return "add_rezerwation.xhtml?faces-redirect=true";
    }

    public void calculateTotalCost() {
        System.out.println("Data rozpoczęcia wypożyczenia: " + newRezerwation.getStart_date());
        System.out.println("Data zakończenia wypożyczenia: " + newRezerwation.getEnd_date());
        System.out.println("Całkowita cena za wypożyczenie: " + selectedMotorcycle.getCena());
        if (newRezerwation.getStart_date() == null || newRezerwation.getEnd_date() == null || selectedMotorcycle.getCena().equals(BigDecimal.ZERO)) {
            this.totalCost = BigDecimal.ZERO;
            return;
        }

        // Obliczamy różnicę dni między datą początkową a końcową
        long diffInDays = ChronoUnit.DAYS.between(newRezerwation.getStart_date(), newRezerwation.getEnd_date());

        // Mnożymy różnicę dni przez cenę za dzień
        this.totalCost = selectedMotorcycle.getCena().multiply(BigDecimal.valueOf(diffInDays));
        System.out.println("Total cost: " + totalCost);
    }

    public String addRezerwation() {
            newRezerwation.setUser(currentUser);
            newRezerwation.setMotorcycle(selectedMotorcycle);
            rezerwationService.saveRezerwation(newRezerwation);
            newRezerwation = new Rezerwation();
            return "add_rezerwation.xhtml?faces-redirect=true";
        }

    public List<Rezerwation> getCurrentUserRezerwations() {
        return rezerwationService.findRezerwationsByUser(currentUser);
    }
}



//        System.out.println("Metoda addRezerwation() została wywołana!");
//        System.out.println("selectedMotorcycleId: " + selectedMotorcycleId);
/* Long selectedMotorcycleId = (Long) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getSessionMap()
                .get("selectedMotorcycleId");
        Optional<Motorcycle> selectedMotorcycleOpt = motorcycleService
                .findMotorcycleById(selectedMotorcycleId);
        selectedMotorcycle = selectedMotorcycleOpt.orElse(null);*/
//        System.out.println("selectedMotorcycleId: " + selectedMotorcycleId);


        /*public String rezerwation() {
            return "add_rezerwation.xhtml?faces-redirect=true";
        }*/


        //        /*FacesContext facesContext = FacesContext.getCurrentInstance();
//        selectedMotorcycleId = facesContext.getExternalContext().getRequestParameterMap().get("selectedMotorcycleId");*/
//        Motorcycle selectedMotorcycle = motorcycleService.findMotorcycleById(selectedMotorcycleId);









