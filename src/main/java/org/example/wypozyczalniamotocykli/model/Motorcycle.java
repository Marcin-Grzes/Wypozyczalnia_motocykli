package org.example.wypozyczalniamotocykli.model;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Motorcycle {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "motorcycle_gen")
    @TableGenerator(name = "motorcycle_gen", initialValue = 2)
    private Long id;
    private String marka;
    private String model;
    private String kolor;
    private int pojemnosc;
    private int moc;
    private int rocznik;
    private BigDecimal cena;
    private String imageLink;

}
