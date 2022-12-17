package com.example.demo4.Repository;

import com.example.demo4.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface productrepo extends JpaRepository<Product,Long> {
//List<Product>findAllByCategory_Id(int id);

    //List<Product> findAllByCategory_id(int id);
}
