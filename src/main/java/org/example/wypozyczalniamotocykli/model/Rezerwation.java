package org.example.wypozyczalniamotocykli.model;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
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

    private LocalDate start_date;

    private LocalDate end_date;

}
