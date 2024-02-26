package org.example.backofficeeshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name="client")
public class Client
{
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long codeClient;
    private String username;
    private String password;
    private String email;
    private String nom;
    private String prenom;
    private String cin;
    private String tel;
    private String mobile;
    private String fax;
    private String civilite;
    private String societe;
    private String sexe;
    private String libelle;
    private Date dateNaissance;
    private boolean FLAG;
}
