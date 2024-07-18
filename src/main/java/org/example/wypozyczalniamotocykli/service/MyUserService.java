package org.example.wypozyczalniamotocykli.service;
import org.example.wypozyczalniamotocykli.model.User_app;
import org.example.wypozyczalniamotocykli.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;



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

        Optional<User_app> userFromDb = userRepository.findById(user.getId());

        if(userFromDb.isPresent()) {
            User_app updateUser = userFromDb.get();

            updateUser.setUsername(user.getUsername());
            updateUser.setPassword(user.getPassword());
            updateUser.setStreet(user.getStreet());
            updateUser.setNumber_house(user.getNumber_house());
            updateUser.setNumber_flat(user.getNumber_flat());
            updateUser.setPostal_code(user.getPostal_code());
            updateUser.setCity(user.getCity());
            updateUser.setPhone_number(user.getPhone_number());

            userRepository.save(updateUser);
        }
    }
}