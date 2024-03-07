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
@Table(name="Stock")
public class Stock {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int codeStock;

    private String couleur;

    private int nombreStock;

    private boolean flag;


    //Jointure avec la table Produit
    @ManyToOne
    @JoinColumn(name = "codeProduit")
    private Produit produit;
}
