package br.com.erudio.model.dto;

import br.com.erudio.model.Cambio;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.function.Function;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class CambioDTO {

    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionFactor;
    private BigDecimal convertedValue;
    private String enviroment;

    public static ToDTO getToDTOConverter() {
        return new ToDTO();
    }

    public static class ToDTO implements Function<Cambio, CambioDTO> {
        @Override
        public CambioDTO apply(Cambio entity) {
            CambioDTO dto = new CambioDTO();
            dto.setId(entity.getId());
            dto.setTo(entity.getTo());
            dto.setFrom(entity.getFrom());
            dto.setConversionFactor(entity.getConversionFactor());

            return dto;
        }

    }
}
