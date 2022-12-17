package com.example.demo4.Model;

import lombok.Data;

import javax.persistence.*;

@Entity //CREATE TABLE
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Categor_id")
    private int id;
    private String namee;


    public Category get() {

        return null;
    }
}
