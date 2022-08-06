package com.example.demo.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "APPARAL")
@PrimaryKeyJoinColumn(name = "id")
public class Apparal extends Product {
    @Column(name="TYPE")
    private String type;
    @Column(name="BRAND")
    private String brand;
    @Column(name="DESIGN")
    private String design;
}
