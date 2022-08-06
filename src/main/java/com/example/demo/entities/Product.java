package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="PRODUCT")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NamedQueries({

        @NamedQuery(name = "Product.findByProductName", query = "SELECT p FROM Product p WHERE p.productName=:name"),
        @NamedQuery(name = "Product.findByProductId", query = "SELECT p FROM Product p WHERE p.id=:productId")

})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "product_name")
    private String productName;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Cart> carts;
    @Column(name = "price")
    private Double price;
}
