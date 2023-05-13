package com.helloSpringBoot.gestionProduits.repositories;

import com.helloSpringBoot.gestionProduits.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    public List<Product> findByNameContains(String mc);

    @Query("select p from Product p where p.category.id=:x")
    public List<Product> getProductByCategory(@Param("x") Integer id);

}
