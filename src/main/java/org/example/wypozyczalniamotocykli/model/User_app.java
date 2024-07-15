package org.example.wypozyczalniamotocykli.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

/*
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
*/

import java.util.Collections;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class User_app {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String username;

    @NonNull
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    private String street;

    private String number_house;

    private String number_flat;

    private String postal_code;

    private String city;

    private int phone_number;

    private String number_driving_license;

    private String number_identity_card;

    private int PESEL;

    @OneToMany(mappedBy = "user")
    private List<Rezerwation> rezerwation = new ArrayList<>();
}


/*

@Data
@Entity
public class User_app implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private boolean active;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(role.name()));
    }}*/
