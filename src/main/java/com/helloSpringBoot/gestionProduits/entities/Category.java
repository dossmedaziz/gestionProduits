package com.helloSpringBoot.gestionProduits.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Size(min = 1, max = 20)
    private String name;
    @OneToMany(mappedBy = "category")//, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Product> products;

}
