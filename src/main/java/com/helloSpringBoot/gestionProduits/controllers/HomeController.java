package com.helloSpringBoot.gestionProduits.controllers;

import com.helloSpringBoot.gestionProduits.entities.Category;
import com.helloSpringBoot.gestionProduits.services.IServiceCategory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
@AllArgsConstructor
public class HomeController {
    private IServiceCategory sc;

    @GetMapping("")
    public String index(Model m) {
        List<Category> categories = sc.getAllCategories();
        m.addAttribute("categories", categories);
        return "home";
    }
}
