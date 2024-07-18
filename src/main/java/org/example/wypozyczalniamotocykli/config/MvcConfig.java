/*package org.example.wypozyczalniamotocykli.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Dodaj tutaj swoje mapowania endpointów
        registry.addViewController("/").setViewName("home");
        registry.addViewController("login").setViewName("login");
        registry.addViewController("registration").setViewName("register");
        registry.addViewController("count").setViewName("modify_user");
        registry.addViewController("addReservation").setViewName("add_rezerwation");
        registry.addViewController("list").setViewName("list_rezerw");// przykład
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/META-INF/resources/", ".xhtml");
    }
}*/
