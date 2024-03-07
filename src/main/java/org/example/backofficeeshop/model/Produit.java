package org.example.backofficeeshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private long codeProduit;
    private String libelle;
    private String description;
    private float prixHT;
    private String image;
    private boolean FLAG;

    //Jointure avec la table Marque
    @OneToOne
    @JoinColumn(name = "codeMarque")
    private Marque marque;


    //Jointure avec la table Gamme
    @ManyToOne
    @JoinColumn(name="codeGamme")
    private Gamme gamme;


    //Jointure avec la table commande
    @ManyToOne
    @JoinColumn(name="codeCommande")
    private Commande commande;


    //Jointure avec la table Stock
    @OneToMany(mappedBy = "produit")
    private List<Stock> listDestock;

}
