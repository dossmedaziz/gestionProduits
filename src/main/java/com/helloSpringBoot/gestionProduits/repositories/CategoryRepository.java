package com.helloSpringBoot.gestionProduits.repositories;

import com.helloSpringBoot.gestionProduits.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
