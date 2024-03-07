package org.example.backofficeeshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.backofficeeshop.model.Commande;
import org.example.backofficeeshop.model.Gamme;
import org.example.backofficeeshop.model.Marque;
import org.example.backofficeeshop.model.Produit;


@Data
@Builder
public class ProduitDto {

    private long codeProduit;
    private String libelle;
    private String description;
    private float prixHT;
    private String image;
    private boolean FLAG;

    private MarqueDto marque;

     private GammeDto gamme;

      private CommandeDto commande;


    public static ProduitDto fromEntity(Produit produit) {
        if (produit == null) {
            return null;
        }
        return ProduitDto.builder()
                .codeProduit(produit.getCodeProduit())
                .libelle(produit.getLibelle())
                .description(produit.getDescription())
                .prixHT(produit.getPrixHT())
                .image(produit.getImage())
                .FLAG(produit.isFLAG())
                .marque(MarqueDto.fromEntity(produit.getMarque()))
                .gamme(GammeDto.fromEntity(produit.getGamme()))
                .commande(CommandeDto.fromEntity(produit.getCommande()))
                .build();
    }
    public static Produit toEntity(ProduitDto produitDto) {
        if (produitDto == null) {
            return null;
        }
        Produit produit = new Produit();
        produit.setCodeProduit(produitDto.getCodeProduit());
        produit.setLibelle(produitDto.getLibelle());
        produit.setDescription(produitDto.getDescription());
        produit.setPrixHT(produitDto.getPrixHT());
        produit.setImage(produitDto.getImage());
        produit.setFLAG(produitDto.isFLAG());
        produit.setMarque(MarqueDto.toEntity(produitDto.getMarque()));
        return produit;
    }




}
