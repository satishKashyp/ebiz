package com.example.demo.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
@Entity
@Table(name = "BOOK")
@PrimaryKeyJoinColumn(name = "id")
@Data
public class Book extends Product{
    @Column(name="genere")
    private String genere;
    @Column(name="authour")
    private String authour;
    @Column(name="publications")
    private String publications;
}
