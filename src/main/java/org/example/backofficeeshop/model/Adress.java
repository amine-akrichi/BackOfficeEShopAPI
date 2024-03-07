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
@Table(name="Adress")
public class Adress {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long codeAdress;

    private int numéro;

    private  String rue;

   private String ville;

   private int CodePostal;

   private  boolean flag;
}
