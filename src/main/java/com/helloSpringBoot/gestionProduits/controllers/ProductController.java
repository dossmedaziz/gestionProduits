package com.helloSpringBoot.gestionProduits.controllers;

import com.helloSpringBoot.gestionProduits.services.IServiceProduct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class ProductController {

    IServiceProduct sp;

    @GetMapping("/home")
    public String getAll(@RequestParam(name = "mc", defaultValue = "") String mc, Model m) {
        m.addAttribute("products", sp.getProductsByMC(mc));
        m.addAttribute("keyWord", mc);
        return "products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        sp.deleteProduct(id);
        return "redirect:/home";
    }
}
