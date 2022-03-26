package com.prompo.knit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.postgresql.util.PGmoney;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private String name;
    @Column
    private Integer count;
    @Column
    private PGmoney price;
    @Column
    private String description;
    @Column
    private boolean isMadeToOrder;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Seller owner;

    @ManyToOne(optional = false)
    private Seller seller;

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
