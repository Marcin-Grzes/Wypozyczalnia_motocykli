package org.example.wypozyczalniamotocykli.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.wypozyczalniamotocykli.model.User_app;
import org.example.wypozyczalniamotocykli.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Scope("session")
@AllArgsConstructor
@NoArgsConstructor // dodatkowy konstruktor bez argumentów
@Getter @Setter
public class ModifyController implements Serializable {
    private MyUserService userService;
    private User_app currentUser;

    @PostConstruct
    public void init() {
        String username = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        // load data on page start
        userService.findByUsername(username).ifPresent(user -> this.currentUser = user);
    }

    // call this method on form submit
    public void save() {
        userService.saveUser_app(currentUser);
    }
}