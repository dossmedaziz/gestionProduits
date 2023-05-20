package com.helloSpringBoot.gestionProduits.services.implementations;

import com.helloSpringBoot.gestionProduits.entities.Category;
import com.helloSpringBoot.gestionProduits.repositories.CategoryRepository;
import com.helloSpringBoot.gestionProduits.services.IServiceCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements IServiceCategory {

    private CategoryRepository cr;

    public CategoryService(CategoryRepository cr) {
        this.cr = cr;
    }

    @Override
    public void addCategory(Category c) {
        cr.save(c);
    }

    @Override
    public List<Category> getAllCategories() {
        return cr.findAll();
    }
}
