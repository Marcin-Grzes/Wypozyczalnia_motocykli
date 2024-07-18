package org.example.wypozyczalniamotocykli.controller;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.wypozyczalniamotocykli.model.User_app;
import org.example.wypozyczalniamotocykli.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.io.Serializable;
import java.util.Optional;
import static java.sql.DriverManager.println;


@Component
@Scope("session")
@AllArgsConstructor
public class LoginController implements Serializable {
    private final MyUserService myUserService;
    private final HttpSession httpSession;

    @Autowired
    public LoginController(MyUserService myUserService, HttpSession httpSession) {
        this.myUserService = myUserService;
        this.httpSession = httpSession;
    }

    @Getter
    @Setter
    private User_app user_app = new User_app();


    public String loginUser() {
        Optional<User_app> existingUser = myUserService.findByUsername(user_app.getUsername());

        if (existingUser.isPresent()) {
            User_app user = existingUser.get();
            if (!user.getPassword().equals(user_app.getPassword())) {
                System.out.println("Niepoprawne hasło");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Niepoprawne hasło.", "Niepoprawne hasło."));
                return "/login";
            } else {
                httpSession.setAttribute("user", user);
                return "home.xhtml?faces-redirect=true";
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Użytkownik o podanej nazwie nie istnieje.", "Użytkownik o podanej nazwie nie istnieje."));
            System.out.println("Brak użytkownika o podanej nazwie");
            return "/login";
        }
    }
}

//        if (existingUser.isEmpty()) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", "Użytkownik o podanej nazwie nie istnieje."));
//            return "login?faces-redirect=true";
//        } else
            /*if (!existingUser.get().getPassword().equals(user_app.getPassword())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", "Niepoprawne hasło."));
            return "login?faces-redirect=true";
        } else {
            httpSession.setAttribute("userId", existingUser.get().getId());
            return "/home";
        }
    }
}*/


