package com.helloSpringBoot.gestionProduits.services.implementations;

import com.helloSpringBoot.gestionProduits.entities.Category;
import com.helloSpringBoot.gestionProduits.entities.Product;
import com.helloSpringBoot.gestionProduits.repositories.CategoryRepository;
import com.helloSpringBoot.gestionProduits.repositories.ProductRepository;
import com.helloSpringBoot.gestionProduits.services.IServiceCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements IServiceCategory {

    private CategoryRepository cr;

    private ProductRepository pr;

    public CategoryService(
            CategoryRepository cr, ProductRepository pr) {
        this.cr = cr;
        this.pr = pr;
    }

    @Override
    public void addCategory(Category c) {
        cr.save(c);
    }

    @Override
    public List<Category> getAllCategories() {
        return cr.findAll();
    }

    @Override
    public void deleteCategory(Integer id) {
        List<Product> products = this.getProductsByCategory(id);
        for (Product p : products) {
            p.setCategory(null);
        }
        cr.deleteById(id);
    }

    @Override
    public Category getCategoryById(Integer id) {
        return cr.findById(id).get();
    }

    @Override
    public List<Product> getProductsByCategory(Integer id) {
        return pr.getProductByCategory(id);
    }
}
