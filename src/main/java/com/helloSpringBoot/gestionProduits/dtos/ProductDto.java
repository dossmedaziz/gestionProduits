package com.helloSpringBoot.gestionProduits.dtos;

import com.helloSpringBoot.gestionProduits.entities.Category;

public record ProductDto(
        Integer id,
        String name,
        double price,
        Integer quantity,
        Category category,
        String image
) {
}
