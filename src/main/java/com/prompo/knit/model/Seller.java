package com.prompo.knit.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "seller")
/***
 * Класс JPA-сущности для таблицы продавцов
 */
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String password;
    @Column
    private String login;
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "seller")
    List<Product> productList;

}
