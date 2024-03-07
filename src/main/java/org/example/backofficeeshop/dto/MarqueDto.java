package org.example.backofficeeshop.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.backofficeeshop.model.Marque;

@Data
@Builder
public class MarqueDto {

    private long codeMarque;
    private String libelle;
    private String logo;
    public static MarqueDto fromEntity(Marque marque) {

            if (marque == null) {
                return null;
                // TODO throw an exception
            }
            return MarqueDto.builder()

                    .codeMarque(marque.getCodeMarque())
                    .libelle(marque.getLibelle())
                    .logo(marque.getLogo())
                    .build();

    }

    public static Marque toEntity(MarqueDto marqueDto) {
        if (marqueDto == null) {
            return null;
            // TODO throw an exception
        }
        Marque marque = new Marque();
        marque.setCodeMarque(marqueDto.getCodeMarque());
        marque.setLibelle(marqueDto.getLibelle());
        marque.setLogo(marqueDto.getLogo());

        return marque;
    }
}
