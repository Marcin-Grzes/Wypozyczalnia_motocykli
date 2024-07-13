package org.example.wypozyczalniamotocykli.controller;

import org.example.wypozyczalniamotocykli.model.User_app;
import org.example.wypozyczalniamotocykli.service.MyUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "/login";
    }
}


