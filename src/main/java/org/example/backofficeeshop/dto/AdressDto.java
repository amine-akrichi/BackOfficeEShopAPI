package org.example.backofficeeshop.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.backofficeeshop.model.Adress;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdressDto {


    private int numero;

    private  String rue;

    private String ville;

    private int CodePostal;

    private  boolean flag;

    public static AdressDto fromEntity(Adress adresse) {
        if (adresse == null) {
            return null;
        }

        return AdressDto.builder()
                //.numéro(adresse.getNuméro())
                .rue(adresse.getRue())
                .ville(adresse.getVille())
                .CodePostal(adresse.getCodePostal())
                .build();
    }

    public static Adress toEntity(AdressDto adresseDto) {
        if (adresseDto == null) {
            return null;
        }
        Adress adresse = new Adress();
       // adresse.setNuméro(adresseDto.getNuméro());
        adresse.setCodePostal(adresseDto.getCodePostal());
        adresse.setVille(adresseDto.getVille());
        adresse.setFlag(adresseDto.isFlag());
        return adresse;
    }

}
