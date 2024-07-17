package org.example.wypozyczalniamotocykli.model;

import lombok.*;
import org.example.wypozyczalniamotocykli.model.User_app;
import org.example.wypozyczalniamotocykli.model.Motorcycle;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data

@RequiredArgsConstructor
public class Rezerwation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User_app user;

    @ManyToOne
    @JoinColumn(name = "motorcycle_id")
    private Motorcycle motorcycle;

    private LocalDateTime start_date;

    private LocalDateTime end_date;
}
