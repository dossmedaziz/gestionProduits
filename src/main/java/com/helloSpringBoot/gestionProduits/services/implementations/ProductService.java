package com.helloSpringBoot.gestionProduits.services.implementations;

import com.helloSpringBoot.gestionProduits.entities.Product;
import com.helloSpringBoot.gestionProduits.repositories.ProductRepository;
import com.helloSpringBoot.gestionProduits.services.IServiceProduct;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class ProductService implements IServiceProduct {


    private ProductRepository pr;

    public ProductService(ProductRepository pr) {
        this.pr = pr;
    }

    @Override
    public void saveProduct(Product p, MultipartFile mf) {
        if (!mf.isEmpty())
            p.setImage(upload(mf));
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
        return pr.findByNameContains(mc, p);
    }

    @Override
    public Product getProductById(Integer id) {
        return pr.findById(id).get();
    }

    @Override
    public List<Product> getProductsByCategory(Integer id) {
        return pr.getProductByCategory(id);
    }

    private String upload(MultipartFile mf) {
        String name = mf.getOriginalFilename();
        String tab[] = name.split("\\.");
        String newName = tab[0] + System.currentTimeMillis() + "." + tab[1];


        try {
            File f = new ClassPathResource("static/photos").getFile();
//        Path p = Paths.get(System.getProperty("user.dir") + "/src/main/resources/static/photos", newName);
            Path p = Paths.get(f.getAbsolutePath() + File.separator, newName);
            Files.write(p, mf.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return newName;
    }
}
