package org.example.wypozyczalniamotocykli.model;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Motorcycle {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "motorcycle_gen")
    @TableGenerator(name = "motorcycle_gen", initialValue = 2)
    private int id;
    @Enumerated(EnumType.STRING)
    private MotorcycleStatus status = MotorcycleStatus.AVAILABLE;
    private String marka;
    private String model;
    private String kolor;
    private int pojemnosc;
    private int moc;
    private int rocznik;
    private BigDecimal cena;
    private String imageLink;

    @OneToMany(mappedBy = "motorcycle", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Rezerwation> rezerwations_motorcycle = new ArrayList<>();

}
