package org.example.backofficeeshop.dto;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;
import org.example.backofficeeshop.model.Commande;
import org.example.backofficeeshop.model.EtatCommande;
import org.example.backofficeeshop.model.Marque;
import org.example.backofficeeshop.model.TypeLivraison;

import java.util.Date;

@Builder
@Data
public class CommandeDto {
    private long codeCommande;
    private Date dateCommande;
    private int nombreTotalProduits;
    private double poidsTotal;
    private float prixTotal;
    private long numExpedition;
    private TypeLivraison typeLivraison;
    private EtatCommande etatCommande;
    private Boolean FLAG;


    public static CommandeDto fromEntity(Commande commande) {

        if (commande == null) {
            return null;
            // TODO throw an exception
        }
        return CommandeDto.builder()
                .codeCommande(commande.getCodeCommande())
                .dateCommande(commande.getDateCommande())
                .nombreTotalProduits(commande.getNombreTotalProduits())
                .prixTotal(commande.getPrixTotal())
                .numExpedition(commande.getNumExpedition())
                .FLAG(commande.getFLAG())
                .build();

    }
}
