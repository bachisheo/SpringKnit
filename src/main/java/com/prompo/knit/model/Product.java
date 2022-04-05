package com.prompo.knit.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private String name;
    @Column
    private Integer count;
    @Column
    private BigDecimal price;
    @Column
    private String description;
    @Column
    private boolean isMadeToOrder;
    @Column(nullable = true)
    private String image;
    @ManyToOne(optional = false)
    private Seller seller;

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
