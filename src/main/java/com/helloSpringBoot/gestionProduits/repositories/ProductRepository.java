package com.helloSpringBoot.gestionProduits.repositories;

import com.helloSpringBoot.gestionProduits.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product , Integer> {
}
