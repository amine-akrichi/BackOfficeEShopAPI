package org.example.backofficeeshop.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name="Commande")
public class Commande {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long codeCommande;
    private Date dateCommande;
    private int nombreTotalProduits;
    private double poidsTotal;
    private float prixTotal;
    private long numExpedition;
    private String etat;
    @Enumerated(EnumType.STRING)
    private TypePayment typePayment;
    private Boolean FLAG;


}


