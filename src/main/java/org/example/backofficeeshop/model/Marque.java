
package org.example.backofficeeshop.model;

import jakarta.persistence.*;
import lombok.*;

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
    private boolean FLAG;
}
