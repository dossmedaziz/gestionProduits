package com.helloSpringBoot.gestionProduits.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Size(min = 1, max = 20)
    private String name;

    @Min(1)
    private double price;

    @Min(0)
    private int quantity;

    @ManyToOne
   // @NotNull(message = "Category is required")
    private Category category;

    private String image;

}
