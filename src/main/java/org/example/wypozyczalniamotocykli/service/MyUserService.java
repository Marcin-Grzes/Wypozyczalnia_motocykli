package org.example.wypozyczalniamotocykli.service;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.example.wypozyczalniamotocykli.model.Motorcycle;
import org.example.wypozyczalniamotocykli.model.Role;
import org.example.wypozyczalniamotocykli.model.User_app;
import org.example.wypozyczalniamotocykli.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;*/
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service

public class MyUserService {
    private final UserRepository userRepository;

    @Autowired
    public MyUserService (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void saveUser_app(User_app user_app) {
        userRepository.save(user_app);
    }
    public List<User_app> getAllUser_app() {
        return userRepository.findAll();
    }
    public Optional<User_app> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public void updateUser(User_app user) {
        // Fetch the user from the database

        Optional<User_app> userFromDb = userRepository.findById(user.getId());

        if(userFromDb.isPresent()) {
            User_app updateUser = userFromDb.get();
            // Set the new values
            updateUser.setUsername(user.getUsername());
            updateUser.setPassword(user.getPassword());
            updateUser.setStreet(user.getStreet());
            updateUser.setNumber_house(user.getNumber_house());
            updateUser.setNumber_flat(user.getNumber_flat());
            updateUser.setPostal_code(user.getPostal_code());
            updateUser.setCity(user.getCity());
            updateUser.setPhone_number(user.getPhone_number());


            // Perform the database update
            userRepository.save(updateUser);
        }
    }
}
/*

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
*/
