package org.example.wypozyczalniamotocykli.controller;

import jakarta.inject.Named;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.RequestScope;

@Named
@RequestScope
public class LogoutController {
    @Autowired
    private HttpSession session;

    public String logout() {
        session.invalidate();
        return "/login.xhtml?faces-redirect=true";
    }

    public boolean isLoggedIn() {
        return session.getAttribute("user") != null;
    }
}
