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
@Table(name="Adresse")
public class Adresse {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long codeAdresse;

    private int numero;

    private  String rue;

   private String ville;

   private int codePostal;

   private  boolean flag;
}
