package org.example.backofficeeshop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "permission")
public class Permission {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long codePermison;
    private String endpoint;
    private String method;
    private Boolean FLAG;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codeRole")
    @JsonManagedReference
    private Role role;

    @JsonBackReference
    public Role getRole() {
        return role;
    }

}
