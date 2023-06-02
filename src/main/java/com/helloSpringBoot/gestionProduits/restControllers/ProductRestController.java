package com.helloSpringBoot.gestionProduits.restControllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.helloSpringBoot.gestionProduits.dtos.ProductDto;
import com.helloSpringBoot.gestionProduits.entities.Product;
import com.helloSpringBoot.gestionProduits.services.IServiceProduct;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("api/products")
public class ProductRestController {

    private IServiceProduct sp;


    @GetMapping("")
    public List<ProductDto> all() {
        return sp.getAllProducts()
                .stream()
                .map(product -> new ProductDto(
                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        product.getQuantity(),
                        product.getCategory(),
                        "http://localhost:8080/photos/" + product.getImage()
                )).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public Product byId(@PathVariable Integer id) {
        return sp.getProductById(id);
    }

    @GetMapping("{keyWord}/search")
    public List<Product> byId(@PathVariable String keyWord) {
        return sp.getProductsByMC(keyWord);
    }

    @PostMapping("")
    public void save(@RequestParam String product, @RequestParam MultipartFile f) throws JsonProcessingException {
        System.out.println(product);
        Product p = new ObjectMapper().readValue(product, Product.class);
        System.out.println(p.toString());
        sp.saveProduct(p, f);
    }
}
