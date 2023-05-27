package com.helloSpringBoot.gestionProduits.services;

import com.helloSpringBoot.gestionProduits.entities.Category;
import com.helloSpringBoot.gestionProduits.entities.Product;

import java.util.List;

public interface IServiceCategory {
    public void addCategory(Category c);
    public List<Category> getAllCategories();

    public void deleteCategory(Integer id) ;

    public Category getCategoryById(Integer id);

    public List<Product> getProductsByCategory(Integer id) ;

}
