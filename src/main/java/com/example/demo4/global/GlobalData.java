package com.example.demo4.global;

import com.example.demo4.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    public static List<Product> cart;
    static {
        cart= new ArrayList<Product>();
    }
}
