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
@Table(name="LigneCommande")
public class LigneCommande {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long codeLigneCommande;
    private Number nombreTotalProduits;
    private float poids;
    private float prix;
    private long numExpedition;

    //Jointure avec la table Commande
    @ManyToOne
    @JoinColumn(name = "codeCommande")
    private Commande commande;

    //Jointure avec produit
    @ManyToOne
    @JoinColumn(name = "codeProduit")
    private Produit produit;




}
