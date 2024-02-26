package org.example.backofficeeshop.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name="Gamme")
public class Gamme{
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long codeGamme;
    private String libelle;
    private boolean FLAG;

}
