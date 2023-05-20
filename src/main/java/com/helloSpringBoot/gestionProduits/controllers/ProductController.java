package com.helloSpringBoot.gestionProduits.controllers;

import com.helloSpringBoot.gestionProduits.entities.Product;
import com.helloSpringBoot.gestionProduits.services.IServiceCategory;
import com.helloSpringBoot.gestionProduits.services.IServiceProduct;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
@RequestMapping("products")
@AllArgsConstructor
public class ProductController {

    private IServiceProduct sp;
    private IServiceCategory sc;

    @GetMapping("")
    public String getAll(@RequestParam(name = "mc", defaultValue = "") String mc, Model m,
                         @RequestParam(name = "page", defaultValue = "1") int page,
                         @RequestParam(name = "size", defaultValue = "10") int size
    ) {
        Page<Product> pages = sp.getProductsByMC(mc, PageRequest.of(page - 1, size));
        m.addAttribute("products", pages.getContent());
        m.addAttribute("index", new int[pages.getTotalPages()]);
        m.addAttribute("currentPage", pages.getNumber());
        m.addAttribute("keyWord", mc);
        return "products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        sp.deleteProduct(id);
        return "redirect:/products";
    }


    @GetMapping("/create")
    public String create(Model m) {
        m.addAttribute("product", new Product());
        m.addAttribute("categories", sc.getAllCategories());


        return "addProduct.html";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute @Valid Product p, BindingResult br, @RequestParam("file") MultipartFile file, Model m) {
        if (br.hasErrors()) {
            m.addAttribute("categories", sc.getAllCategories());
            return "addProduct.html";

        }
        sp.saveProduct(p, file);
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model m) {
        m.addAttribute("product", sp.getProductById(id));
        m.addAttribute("categories", sc.getAllCategories());


        return "addProduct.html";

    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable Integer id, @ModelAttribute Product p) {
        System.out.println("update function is called with id: " + id);
        //    sp.saveProduct(p);
        return "redirect:/products";
    }
}
