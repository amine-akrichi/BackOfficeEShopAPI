package org.example.backofficeeshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;



@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name="Theme")
public class Theme {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long codeTheme;

    private String libellé;

    private boolean Flag;





   //Jointure avec la table Gamme
    @ManyToOne
    @JoinColumn(name="codeGamme")
    private Gamme gamme;


    //Jointure avec la table Caractéristique
    @OneToMany(mappedBy = "theme")
    private List<Caracteristique> caracteristiques;
}
