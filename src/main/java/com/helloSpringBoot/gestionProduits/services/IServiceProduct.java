package com.helloSpringBoot.gestionProduits.services;

import com.helloSpringBoot.gestionProduits.entities.Product;

import java.util.List;

public interface IServiceProduct {

    public void saveProduct(Product p);

    public void deleteProduct(Integer id);

    public List<Product> getAllProducts();

    public List<Product> getProductsByMC(String mc);

    public Product getProductById(Integer id);

    public List<Product> getProductsByCategory(Integer id);
}
