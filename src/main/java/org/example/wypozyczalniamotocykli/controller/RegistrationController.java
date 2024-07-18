package org.example.wypozyczalniamotocykli.controller;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.wypozyczalniamotocykli.model.User_app;
import org.example.wypozyczalniamotocykli.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.util.Optional;



@Component
@Scope("session")
@AllArgsConstructor
public class RegistrationController implements Serializable {
    private final MyUserService myUserService;

    @Autowired
    public RegistrationController(MyUserService myUserService) {
        this.myUserService = myUserService;
    }

    @Getter
    @Setter
    private User_app user_app = new User_app();


    public String newUser() {
        Optional<User_app> existingUser = myUserService.findByUsername(user_app.getUsername());

        if (existingUser.isPresent()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Użytkownik o podanej nazwie już istnieje", "Użytkownik o podanej nazwie już istnieje"));
            return "/register";
        } else {
            myUserService.saveUser_app(user_app);
            return "login?faces-redirect=true";
    }}
}
