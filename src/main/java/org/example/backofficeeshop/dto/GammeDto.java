package org.example.backofficeeshop.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import org.example.backofficeeshop.model.Gamme;


@Data
@Builder
public class GammeDto {

    private long codeGamme;
    private String libelle;
    private boolean FLAG;

    public static GammeDto fromEntity(Gamme gamme) {
        if (gamme == null) {
            return null;
            // TODO throw an exception
        }

        return GammeDto.builder()
                .codeGamme(gamme.getCodeGamme())
                .libelle(gamme.getLibelle())
                .FLAG(gamme.isFLAG())
                .build();
    }

    public static Gamme toEntity(GammeDto gammeDto) {
        if (gammeDto == null) {
            return null;
            // TODO throw an exception
        }

        Gamme gamme= new Gamme();
        gamme.setCodeGamme(gamme.getCodeGamme());
        gamme.setLibelle(gammeDto.getLibelle());
        gamme.setFLAG(gammeDto.isFLAG());

        return gamme;
    }
}
