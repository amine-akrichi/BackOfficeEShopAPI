package org.example.backofficeeshop.dto;


import lombok.Builder;
import lombok.Data;
import org.example.backofficeeshop.model.Client;

import java.util.Date;

@Data
@Builder
public class ClientDto {
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


    public static ClientDto fromEntity(Client client) {
        if (client == null) {
            return null;
            // TODO throw an exception
        }

        return ClientDto.builder()
                .codeClient(client.getCodeClient())
                .username(client.getUsername())
                .libelle(client.getLibelle())
                .FLAG(client.isFLAG())
                .build();
    }

}
