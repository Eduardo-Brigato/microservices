package br.com.erudio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@Entity(name = "book")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "author", nullable = false, length = 180)
    private String author;
    @Column(name = "launch_Date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date launchDate;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false, length = 250)
    private String title;
    @Transient
    private String currency;
    @Transient
    private String enviroment;

    public Book(){
    }

    public Book(Long id, String author, String title, Date launchDate, BigDecimal price, String currency, String enviroment) {
        this.id = id;
        this.author = author;
        this.launchDate = launchDate;
        this.price = price;
        this.title = title;
        this.currency = currency;
        this.enviroment = enviroment;
    }
}
