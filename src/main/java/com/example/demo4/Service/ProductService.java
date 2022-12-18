package com.example.demo4.Service;

import com.example.demo4.Model.Category;
import com.example.demo4.Model.Product;
import com.example.demo4.Repository.productrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final productrepo productrepo;

    public ProductService(productrepo productrepo) {
        this.productrepo = productrepo;
    }

    public List<Product> getAllProduct()
    {
        return productrepo.findAll();
    }
    public void addProduct(Product product){
       productrepo.save(product);
    }
    public void removeProductById(long id){
       productrepo.deleteById(id);
    }
    public Optional<Product>getProductById(long id){
        return productrepo.findById(id);
    }
    //just ekta category er product dekhabe
//    public List<Product>getAllproductsByCategoryId(int id){
//        return productrepo.findAllByCategory_id(id);
//    }
}
