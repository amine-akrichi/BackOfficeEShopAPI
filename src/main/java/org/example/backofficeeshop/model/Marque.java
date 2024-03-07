
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
@Table(name="Marque")
public class Marque {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long codeMarque;
    private String libelle;
    private String logo;


    //Jointure avec la table Produit
    @OneToMany(mappedBy = "marque")
    private List<Produit> produits;


}
