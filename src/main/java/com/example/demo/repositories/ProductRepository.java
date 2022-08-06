package com.example.demo.repositories;

import com.example.demo.entities.Product;
import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE p.id=:productId")
    public Product findByProductId(@Param("productId") Integer productId);
    //@Query("Product.findByName")
    @Query("SELECT p FROM Product p WHERE p.productName=:productName")
    public List<Product> findByProductName(@Param("productName") String productName);


}
