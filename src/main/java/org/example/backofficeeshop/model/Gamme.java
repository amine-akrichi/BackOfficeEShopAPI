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
@Table(name="gamme")
public class Gamme{
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long codeGamme;
    private String libelle;
    private boolean FLAG;


    //Jointure avec la table Produit
   @OneToMany(fetch = FetchType.LAZY,mappedBy = "gamme")
    private List<Produit> produits;

   //Jointure avec la table Theme
   @OneToMany(fetch = FetchType.LAZY,mappedBy = "gamme")
   private List<Theme> themes;

}
