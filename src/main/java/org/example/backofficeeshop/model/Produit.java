package org.example.backofficeeshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name="produits")
public class Produit {

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
