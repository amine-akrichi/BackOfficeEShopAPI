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
@Table(name="Caracteristique")
public class Caracteristique {


        @Id
        @GeneratedValue(
                strategy = GenerationType.IDENTITY
        )
        private Long codeCaracteristique;

        private String libelle;

        private boolean flag;


        //Jointure avec la table Theme
        @ManyToOne
        @JoinColumn(name = "codeTheme")
        private Theme theme;
}
