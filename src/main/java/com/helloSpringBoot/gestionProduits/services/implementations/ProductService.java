package com.helloSpringBoot.gestionProduits.services.implementations;

import com.helloSpringBoot.gestionProduits.entities.Product;
import com.helloSpringBoot.gestionProduits.repositories.ProductRepository;
import com.helloSpringBoot.gestionProduits.services.IServiceProduct;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IServiceProduct {


    private ProductRepository pr;

    public ProductService(ProductRepository pr) {
        this.pr = pr;
    }

    @Override
    public void saveProduct(Product p) {
        pr.save(p);
    }

    @Override
    public void deleteProduct(Integer id) {
        pr.deleteById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return pr.findAll();
    }

    @Override
    public Page<Product> getProductsByMC(String mc, Pageable p) {
        return pr.findByNameContains(mc , p);
    }

    @Override
    public Product getProductById(Integer id) {
        return pr.findById(id).get();
    }

    @Override
    public List<Product> getProductsByCategory(Integer id) {
        return pr.getProductByCategory(id);
    }
}
