package org.example.wypozyczalniamotocykli.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/home.xhtml");
        registry.addViewController("/login").setViewName("forward:/login.xhtml");
        registry.addViewController("/register").setViewName("forward:/register.xhtml");
    }

}
