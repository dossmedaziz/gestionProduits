package com.helloSpringBoot.gestionProduits.restControllers;


import com.helloSpringBoot.gestionProduits.entities.Product;
import com.helloSpringBoot.gestionProduits.services.IServiceProduct;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/products")
public class ProductRestController {

    private IServiceProduct sp;


    @GetMapping("")
    public List<Product> all() {
        return sp.getAllProducts();
    }

    @GetMapping("{id}")
    public Product byId(@PathVariable Integer id) {
        return sp.getProductById(id);
    }

    @GetMapping("{keyWord}/search")
    public List<Product> byId(@PathVariable String keyWord) {
        return sp.getProductsByMC(keyWord);
    }

}
