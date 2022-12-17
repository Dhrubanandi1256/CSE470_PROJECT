package com.example.demo4.controller;

import com.example.demo4.Model.Category;
import com.example.demo4.Model.Product;
import com.example.demo4.Service.CategoryService;
import com.example.demo4.Service.ProductService;
import com.example.demo4.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
@Controller
public class UserController {
    public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages";


    @Autowired
    CategoryService categoryService;
    @Autowired

    ProductService productService;

    @GetMapping("/index")
    public String inedex() {
        return "index";
    }

    @GetMapping("/admin")
    public String adminhome() {
        return "adminhome";
    }

    @GetMapping("/admin/categories")
    public String getcat(Model model) {
        model.addAttribute("categories", categoryService.getAllCategory());
        return "categories";
    }

    @GetMapping("/admin/categories/add")
    public String getcatadd(Model model) {
        model.addAttribute("category", new Category());//BLANK CATAEGORY OBJECT PASS
        return "categoriesADD";
    }


    @PostMapping("/admin/categories/add")
//    public String postcatadd(Model model,Category category){//@ModelAttribute("category")//
    public String postcatadd(@ModelAttribute("category") Category category) {
        // model.addAttribute("category", new Category());
        //System.out.println(category.getNamee());
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
        //model.addAttribute("categories",categoryService.getAllCategory());
        //  return "categories";
    }

    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCat(@PathVariable int id) {
        categoryService.removeCategoryById(id);
        return "redirect:/admin/categories";

    }

    @GetMapping("/admin/categories/update/{id}")
    public String updateCat(@PathVariable int id, Model model) {
        Optional<Category> category = categoryService.getCategoryById(id);
        if (category.isPresent()) {
            model.addAttribute("category", category.get());
            return "categoriesADD";
        } else
            return "404";
        //return null;
    }
    // Category section End


    ///PRODUCT Section
    @GetMapping("/admin/products")
    public String products(Model model) {
        model.addAttribute("products", productService.getAllProduct());//LIst
        return "products";

    }

    //PRODUCTADD
    @GetMapping("/admin/products/add")
    public String ProductAddGet(Model model) {
        model.addAttribute("productdto", new ProductDto());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "proAdd";

    }
//    @PostMapping("/admin/products/add")
//    public String productAddPost(@ModelAttribute("ProductDto") ProductDto productDto,
//                                 //  @RequestParam("productImage") MultipartFile
//                                 file, @RequestParam("imgName") String imgName) throws IOException{

    @PostMapping("/admin/products/add")
    public String productAddPost(@ModelAttribute("ProductDto") ProductDto productDto
    ) throws IOException {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        // product.setCategory(categoryService.getCategoryById(productDto.getCategoryId()).get());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
//        String imageUUID;
//        if (!file.isEmpty()) {
//            imageUUID = file.getOriginalFilename();
//            String uploadDir = null;
//            Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
//
//            Files.write(fileNameAndPath, file.getBytes());
//        } else {
//            imageUUID = imgName;
//        }
//        product.setImagename(imageUUID);
        productService.addProduct(product);

        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/delete/{id}")
    public String deleteProduct(@PathVariable long id) {
        productService.removeProductById(id);
        return "redirect:/admin/products";

    }

    @GetMapping("/admin/product/update/{id}")
    public String updateProduct(@PathVariable long id, Model model) {
        Product product = productService.getProductById(id).get();
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        // productDto.setCategoryId(product.getCategory().getId());
        productDto.setPrice((int) product.getPrice());
        // productDto.getdescription(product.getdescription());
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("productdto", productDto);


        return "proAdd";
    }
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<    MINE CODE>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//    @GetMapping("/admin/products")
//    public String products(Model model) {
//        model.addAttribute("products", productService.getAllProduct());//LIst
//        return "products";
//
//    }
//
//    //PRODUCTADD
//    @GetMapping("/admin/products/add")
//    public String ProductAddGet(Model model) {
//        model.addAttribute("productdto", new ProductDto());
//        model.addAttribute("categories", categoryService.getAllCategory());
//        return "proAdd";
//
//    }
////    @PostMapping("/admin/products/add")
////    public String productAddPost(@ModelAttribute("ProductDto") ProductDto productDto,
////                                 //  @RequestParam("productImage") MultipartFile
////                                 file, @RequestParam("imgName") String imgName) throws IOException{
//
//    @PostMapping("/admin/products/add")
//    public String productAddPost(@ModelAttribute("ProductDto") ProductDto productDto
//    ) throws IOException {
//        Product product = new Product();
//        product.setId(productDto.getId());
//        product.setName(productDto.getName());
//        // product.setCategory(categoryService.getCategoryById(productDto.getCategoryId()).get());
//        product.setPrice(productDto.getPrice());
//        product.setDescription(productDto.getDescription());
////        String imageUUID;
////        if (!file.isEmpty()) {
////            imageUUID = file.getOriginalFilename();
////            String uploadDir = null;
////            Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
////
////            Files.write(fileNameAndPath, file.getBytes());
////        } else {
////            imageUUID = imgName;
////        }
////        product.setImagename(imageUUID);
//        productService.addProduct(product);
//
//        return "redirect:/admin/products";
//    }
//
//    @GetMapping("/admin/product/delete/{id}")
//    public String deleteProduct(@PathVariable long id) {
//        productService.removeProductById(id);
//        return "redirect:/admin/products";
//
//    }
//
//    @GetMapping("/admin/product/update/{id}")
//    public String updateProduct(@PathVariable long id, Model model) {
//        Product product =productService.getProductById(id).get();
//        ProductDto productDto =new  ProductDto();
//        productDto.setId(product.getId());
//        productDto.setName(product.getName());
//        // productDto.setCategoryId(product.getCategory().getId());
//        productDto.setPrice((int) product.getPrice());
//        // productDto.getdescription(product.getdescription());
//        model.addAttribute("categories",categoryService.getAllCategory());
//        model.addAttribute("productdto",productDto);
//
//
//
//        return "proAdd";
//    }
//
//}
//
}