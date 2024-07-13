package org.example.wypozyczalniamotocykli.controller;

import org.example.wypozyczalniamotocykli.model.User_app;
import org.example.wypozyczalniamotocykli.service.MyUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private final MyUserService myUserService;

    public RegistrationController(MyUserService myUserService) {
        this.myUserService = myUserService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String newUser(User_app user_app) {
        myUserService.save(user_app);
        return "redirect:/login";
    }
}
