package org.example.wypozyczalniamotocykli.service;

import org.example.wypozyczalniamotocykli.model.Role;
import org.example.wypozyczalniamotocykli.model.User_app;
import org.example.wypozyczalniamotocykli.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;


@Service
public class MyUserService implements UserDetailsService {

        @Autowired
        private UserRepository userRepository;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            User_app user = userRepository.findByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException(username);
            }
            return new User(user.getUsername(), user.getPassword(), user.getAuthorities());
        }
        public User_app save(User_app userApp) {
        // prawdopodobnie zapisujesz tutaj dane użytkownika za pomocą repozytorium
        return userRepository.save(userApp);
    }

    private GrantedAuthority convertAuthority(Role role){
        return new SimpleGrantedAuthority(role.name());
    }
    }
