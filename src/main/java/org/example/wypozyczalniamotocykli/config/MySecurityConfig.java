package org.example.wypozyczalniamotocykli.config;

/*import org.example.wypozyczalniamotocykli.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
/*import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;

import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;*/
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

import static org.springframework.security.config.Customizer.withDefaults;


/*
@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .csrf().disable()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .httpBasic();
    }

*/




//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                        .antMatchers("/register", "/login").permitAll()
//                        .antMatchers("/admin/**").hasRole("ADMIN")
//                        .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
//                        .anyRequest().authenticated()
//                        .and()
//                        .httpBasic();
//        return http.build();
//    }


//http.authorizeHttpRequests((authz) -> authz

/*@EnableWebSecurity
public class MySecurityConfig {

    private final MyUserService myUserService;

    public MySecurityConfig(MyUserService myUserService) {
        this.myUserService = myUserService;
    }

    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserService).passwordEncoder(passwordEncoder());
    }

    // You can define the password encoding scheme via a Bean like so...
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Wyłączamy ochronę CSRF
                .authorizeRequests()
                .mvcMatchers("/register", "/login").permitAll()
                .mvcMatchers("/admin/**").hasRole("ADMIN")
                .mvcMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
                .and()
                .httpBasic();
        return http.build();
    }
}*/
