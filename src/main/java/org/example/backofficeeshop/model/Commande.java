package org.example.backofficeeshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

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
 //   private String etat;
    @Enumerated(EnumType.STRING)
    private TypeLivraison typeLivraison;

    @Enumerated(EnumType.STRING)
    private EtatCommande etatCommande;
    private Boolean FLAG;

    //Jointure avec la table ligneCommande
    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL)
    private List<LigneCommande> ligneCommandes;

    //Jointure avec la table produit
    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL)
    private List<Produit> produits;


    //Jointure avec la table Client
    @ManyToOne
    @JoinColumn(name = "codeClient")
    private Client client;

}


