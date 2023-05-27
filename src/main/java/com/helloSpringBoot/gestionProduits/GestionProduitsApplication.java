package com.helloSpringBoot.gestionProduits;

import com.helloSpringBoot.gestionProduits.entities.Category;
import com.helloSpringBoot.gestionProduits.entities.Product;
import com.helloSpringBoot.gestionProduits.repositories.CategoryRepository;
import com.helloSpringBoot.gestionProduits.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionProduitsApplication implements CommandLineRunner {
    private ProductRepository pr;

    private CategoryRepository cr;

    public GestionProduitsApplication(
            ProductRepository pr,
            CategoryRepository cr) {
        this.pr = pr;
        this.cr = cr;
    }

    public static void main(String[] args) {
        System.out.println("hello spring doss");
        SpringApplication.run(GestionProduitsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
         cr.save(new Category(null, "Clothes", null));
         cr.save(new Category(null, "It", null));

//        pr.save(new Product(null, "pc portable", 3000, 5, cr.findById(1).get()));
//        pr.save(new Product(null, "keyboard", 120, 5, cr.findById(1).get()));
//        pr.save(new Product(null, "mouse", 10, 5, cr.findById(1).get()));
    }
}
