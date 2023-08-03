package br.com.erudio.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@Entity(name="Cambio")
public class Cambio implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "from_currency", nullable = false, length = 3)
    private String from;
    @Column(name = "to_currency", nullable = false, length = 3)
    private String to;
    @Column(nullable = false)
    private BigDecimal conversionFactor;
    @Transient
    private BigDecimal convertedValue;
    @Transient
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
