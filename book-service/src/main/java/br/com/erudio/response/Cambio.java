package br.com.erudio.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
public class Cambio implements Serializable {

    private static final Long serialVersionUID = 1L;

    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionFactor;
    private BigDecimal convertedValue;
    private String enviroment;

    public Cambio(){

    }

    public Cambio(Long id, String from, String to, BigDecimal conversionFactory, BigDecimal convertedValue, String enviroment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionFactor = conversionFactory;
        this.convertedValue = convertedValue;
        this.enviroment = enviroment;
    }
}
