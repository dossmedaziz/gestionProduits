package com.helloSpringBoot.gestionProduits.controllers;

import com.helloSpringBoot.gestionProduits.services.IServiceProduct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class ProductController {

    IServiceProduct sp;

    @GetMapping("/home")
    public String getAll(Model m) {
        m.addAttribute("products", sp.getAllProducts());
        return "products";


    }
}
