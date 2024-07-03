package org.example.wypozyczalniamotocykli.model;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import lombok.Data;

@Named
@RequestScoped

@Data
public class UserBean {
    private String name;
    public String submit() {
        return "welcome"; // Nawigacja do welcome.xhtml
    }
}
