package com.helloSpringBoot.gestionProduits.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String name ;
    @OneToMany(mappedBy = "category" , cascade = CascadeType.ALL)
    private List<Product> products ;

}
