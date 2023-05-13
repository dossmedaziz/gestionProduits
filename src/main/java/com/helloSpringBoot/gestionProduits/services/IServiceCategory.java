package com.helloSpringBoot.gestionProduits.services;

import com.helloSpringBoot.gestionProduits.entities.Category;

import java.util.List;

public interface IServiceCategory {
    public void addCategory(Category c);
    public List<Category> getAllCategories();
}
