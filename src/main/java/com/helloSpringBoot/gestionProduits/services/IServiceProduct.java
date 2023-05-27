package com.helloSpringBoot.gestionProduits.services;

import com.helloSpringBoot.gestionProduits.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IServiceProduct {

    public void saveProduct(Product p , MultipartFile  mf);

    public void deleteProduct(Integer id);

    public List<Product> getAllProducts();

    public Page<Product> getProductsByMC(String mc , Pageable p);
    public List<Product> getProductsByMC(String mc);

    public Product getProductById(Integer id);

    public List<Product> getProductsByCategory(Integer id);
}
