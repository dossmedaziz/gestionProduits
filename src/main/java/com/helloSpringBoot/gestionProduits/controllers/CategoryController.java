package com.helloSpringBoot.gestionProduits.controllers;

import com.helloSpringBoot.gestionProduits.entities.Category;
import com.helloSpringBoot.gestionProduits.entities.Product;
import com.helloSpringBoot.gestionProduits.services.IServiceCategory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("categories")
@AllArgsConstructor
public class CategoryController {
    private IServiceCategory sc;


    @GetMapping("")
    public String getAll(@RequestParam(name = "mc", defaultValue = "") String mc, Model m) {
        List<Category> categories = sc.getAllCategories();
        m.addAttribute("categories", categories);

        return "categories";

    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Integer id) {
        sc.deleteCategory(id);
        return "redirect:/categories";
    }


    @GetMapping("/create")
    public String create(Model m) {
        m.addAttribute("category", new Category());
        return "addCategory.html";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute @Valid Category c, BindingResult br) {
        if (br.hasErrors()) {
            return "addCategory.html";

        }
        sc.addCategory(c);
        return "redirect:/categories";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model m) {
        m.addAttribute("category", sc.getCategoryById(id));
        return "addCategory.html";

    }

}
