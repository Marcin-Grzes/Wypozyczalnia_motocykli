package org.example.wypozyczalniamotocykli.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.Getter;
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
@Getter @Setter
public class ModifyController  {
    private final MyUserService myUserService;
    private User_app currentUser;
    private final HttpSession httpSession;

    @Autowired
    public ModifyController(MyUserService myUserService, HttpSession httpSession) {
        this.myUserService = myUserService;
        this.httpSession = httpSession;
    }
    @PostConstruct
    public void init() {
        User_app currentUser = (User_app) httpSession.getAttribute("user");
        this.currentUser = currentUser;
        // load data on page start
        System.out.println("User object loaded from database: " + currentUser);
    }

    // call this method on form submit
    public void save() {
        myUserService.updateUser(currentUser);
    }
}


/*
@PostConstruct
public void init() {
    username = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
    System.out.println("Username obtained from FacesContext: " + username);
    // load data on page start
    userService.findByUsername(username).ifPresent(currentUser -> this.currentUser = currentUser);
    System.out.println("User object loaded from database: " + currentUser);
}*/
