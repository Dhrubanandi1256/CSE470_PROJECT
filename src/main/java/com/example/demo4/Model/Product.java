package com.example.demo4.Model;

import lombok.Data;

import javax.persistence.*;
@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;
    private String name;
//    @ManyToOne(fetch = FetchType.LAZY)
//   @JoinColumn(name="Categor_id",referencedColumnName = "Categor_id")
   // private Category category;//OBJECT
        private int price;

    private String description;
    //private String imagename;

    public Product() {

    }

    public Product(Long id, String name, int price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }
}
