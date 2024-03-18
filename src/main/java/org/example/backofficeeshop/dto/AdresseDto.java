package org.example.backofficeeshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.backofficeeshop.model.Adresse;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdresseDto {


    private int numero;

    private  String rue;

    private String ville;

    private int CodePostal;

    private  boolean flag;

    public static AdresseDto fromEntity(Adresse adresse) {
        if (adresse == null) {
            return null;
        }

        return AdresseDto.builder()
                .numero(adresse.getNumero())
                .rue(adresse.getRue())
                .ville(adresse.getVille())
                .CodePostal(adresse.getCodePostal())
                .build();
    }

    public static Adresse toEntity(AdresseDto adresseDto) {
        if (adresseDto == null) {
            return null;
        }
        return Adresse.builder()
                .numero(adresseDto.getNumero())
                .codePostal(adresseDto.getCodePostal())
                .ville(adresseDto.getVille())
                .flag(adresseDto.isFlag())
                .build();

    }

}
