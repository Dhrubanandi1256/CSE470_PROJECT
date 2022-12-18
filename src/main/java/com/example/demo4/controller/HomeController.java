package com.example.demo4.controller;

import com.example.demo4.Service.CategoryService;
import com.example.demo4.Service.ProductService;
import com.example.demo4.global.GlobalData;
//import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.PushBuilder;
import javax.swing.plaf.PanelUI;

@Controller

public class HomeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "index";
    }
    @GetMapping({"/shop"})
    public String shop(Model model) {
        model.addAttribute("categories",categoryService.getAllCategory());
        model.addAttribute("products",productService.getAllProduct());
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "shop";
    }
    @GetMapping({"/shop/category/{id}"})
    public String shopByCategory(Model model, @PathVariable int id) {
        model.addAttribute("categories",categoryService.getAllCategory());
       // model.addAttribute("products",productService.getAllproductsByCategoryId(id));
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "shop";
    }
//    @GetMapping("/shop/viewproduct/{id}")
//    public String viewProduct(Model model,@PathVariable int id) {
//       model.addAttribute("products",productService.getProductById(id));
//
//        return "viewProduct";
//    }
    @GetMapping({"/allproduct"})
    public String allproduct(Model model) {
        model.addAttribute("products", productService.getAllProduct());
        return "allpro";
    }
    @GetMapping({"/allmob"})
    public String allmobile(Model model) {
        model.addAttribute("products", productService.getAllProduct());
        return "allmobile";
    }
    @GetMapping({"/allearphone2"})
    public String allear(Model model) {
        model.addAttribute("products", productService.getAllProduct());
        return "allearphone";
    }

}
