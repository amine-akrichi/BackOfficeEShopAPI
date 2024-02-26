package org.example.backofficeeshop.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name="produits")
public class Produits {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long codeProdit;
    private String libelle;
    private String description;
    private float prixHT;
    private String image;
    private boolean FLAG;

}
