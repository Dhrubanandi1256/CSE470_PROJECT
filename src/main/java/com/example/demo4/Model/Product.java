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

}
