/*
package org.example.wypozyczalniamotocykli.repository;

import org.example.wypozyczalniamotocykli.model.User_app;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class User_appRepositoryImpl implements UserRepository{

    private final Map<String, User_app> users = new HashMap<>();

    @Override
    public String save(User_app user_app) {
        var username = user_app.getUsername();

        if (users.containsKey(username)) {
            throw new IllegalStateException("User already exists");
        }
        users.put(username, user_app);
        return username;
    }

    @Override
    public Optional<User_app> findByUsername(String username) {
        return Optional.ofNullable(users.getOrDefault(username, null));
    }
}
*/
