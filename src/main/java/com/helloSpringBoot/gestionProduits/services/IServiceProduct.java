package com.helloSpringBoot.gestionProduits.services;

import com.helloSpringBoot.gestionProduits.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceProduct {

    public void saveProduct(Product p);

    public void deleteProduct(Integer id);

    public List<Product> getAllProducts();

    public Page<Product> getProductsByMC(String mc , Pageable p);

    public Product getProductById(Integer id);

    public List<Product> getProductsByCategory(Integer id);
}
