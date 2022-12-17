package com.example.demo4.dto;

import lombok.Data;


@Data

public class ProductDto {
        private long index;
        private Long id;
        private String name;
        private int CategoryId;
        private int price;
        //private double weight;
        private String description;

}
