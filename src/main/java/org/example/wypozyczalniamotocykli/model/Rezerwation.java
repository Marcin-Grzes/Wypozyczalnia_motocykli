package org.example.wypozyczalniamotocykli.model;

import lombok.*;
import org.example.wypozyczalniamotocykli.model.User_app;
import org.example.wypozyczalniamotocykli.model.Motorcycle;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Rezerwation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User_app user;

    @OneToMany(mappedBy = "rezerwation", fetch = FetchType.EAGER)
    private List<Motorcycle> motorcycle = new ArrayList<>();

    private LocalDateTime start_date;

    private LocalDateTime end_date;
}
