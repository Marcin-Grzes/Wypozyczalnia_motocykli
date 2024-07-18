package org.example.wypozyczalniamotocykli.controller;

import jakarta.faces.application.FacesMessage;
import jakarta.servlet.http.HttpSession;
import org.example.wypozyczalniamotocykli.model.User_app;
import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import lombok.*;
import org.example.wypozyczalniamotocykli.model.Motorcycle;
import org.example.wypozyczalniamotocykli.model.Rezerwation;
import org.example.wypozyczalniamotocykli.service.MotorcycleService;
import org.example.wypozyczalniamotocykli.service.RezerwationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
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
    private final LogoutController logoutController;

    @Autowired
    public RezerwationController(RezerwationService rezerwationService,
                                 MotorcycleService motorcycleService,
                                 HttpSession httpSession,
                                 LogoutController logoutController ) {
        this.rezerwationService = rezerwationService;
        this.motorcycleService = motorcycleService;
        this.httpSession = httpSession;
        this.logoutController = logoutController;
    }

    @PostConstruct
    public String rezerwation() {
        if(!logoutController.isLoggedIn())
            return "/login.xhtml?faces-redirect=true";
        else {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        this.selectedMotorcycleId = facesContext.getExternalContext().getRequestParameterMap().get("selectedMotorcycleId");
        System.out.println("selectedMotorcycleId: " + selectedMotorcycleId);

        Long motorcycleId = Long.valueOf(selectedMotorcycleId);
        Optional<Motorcycle> motorcycleOpt = motorcycleService.findMotorcycleById(motorcycleId);
        Motorcycle foundMotorcycle = motorcycleOpt.orElse(null);
        if (foundMotorcycle != null) {
            this.selectedMotorcycle = foundMotorcycle;
        } else {


            this.selectedMotorcycle = null;
        }


        User_app currentUser = (User_app) httpSession.getAttribute("user");
        this.currentUser = currentUser;
        // load data on page start
        System.out.println("User object loaded from database: " + currentUser);


        return "add_rezerwation.xhtml?faces-redirect=true";
    }}

    public void calculateTotalCost() {
        if (newRezerwation.getStart_date() == null || newRezerwation.getEnd_date() == null || selectedMotorcycle.getCena().equals(BigDecimal.ZERO)) {
            this.totalCost = BigDecimal.ZERO;
            return;
        }

        long diffInDays = ChronoUnit.DAYS.between(newRezerwation.getStart_date(), newRezerwation.getEnd_date());


        this.totalCost = selectedMotorcycle.getCena().multiply(BigDecimal.valueOf(diffInDays));
    }
    public void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void addRezerwation() {
            newRezerwation.setUser(currentUser);
            newRezerwation.setMotorcycle(selectedMotorcycle);
            rezerwationService.saveRezerwation(newRezerwation);
            newRezerwation = new Rezerwation();
            System.out.println("Rezerwacja została dodana!");
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Sukces", "Rezerwacja zapisana pomyślnie!"));
        }
}









