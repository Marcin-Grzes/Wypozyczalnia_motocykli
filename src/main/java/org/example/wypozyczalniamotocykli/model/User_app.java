package org.example.wypozyczalniamotocykli.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor

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

    private Integer phone_number;

    private String number_driving_license;

    private String number_identity_card;

    private Integer PESEL;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Rezerwation> rezerwation = new ArrayList<>();
}