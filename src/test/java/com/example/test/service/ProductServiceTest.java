package com.example.test.service;

import com.example.demo4.Model.Product;
import com.example.demo4.Repository.productrepo;
import com.example.demo4.Service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private productrepo productrepo;
    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllProduct() {
        List<Product> expectedProducts = Arrays.asList(
                new Product(1L, "Product 1", 12, "test product"),
                new Product(2L, "Product 2", 15, "test product")
        );
        when(productrepo.findAll()).thenReturn(expectedProducts);

        // Call the method under test
        List<Product> actualProducts =  productService.getAllProduct();
        // Verify the results
        assertEquals(expectedProducts, actualProducts);
    }

    @Test
    void addProduct() {
        Product newProduct = new Product(null, "Product 3", 15, "Description");
        when(productrepo.save(newProduct))
                .thenReturn(
                        new Product(3L, "Product 3", 15, "Description")
                );

        // Call the method under test
        productService.addProduct(newProduct);

        // Verify that the save method was called with the correct argument
        verify(productrepo).save(newProduct);
    }

    @Test
    void removeProductById() {
        // Set up mock data and expectations
        long productId = 1;
        doNothing().when(productrepo).deleteById(productId);

        // Call the method under test
        productService.removeProductById(productId);

        // Verify that the deleteById method was called with the correct argument
        verify(productrepo).deleteById(productId);
    }

    @Test
    void getProductById() {
        // Set up mock data and expectations
        long productId = 1;
        Product expectedProduct = new Product(1L, "Product 1", 15, "Deescription");
        when(productrepo.findById(productId)).thenReturn(Optional.of(expectedProduct));
        when(productrepo.findById(2L)).thenReturn(Optional.empty());
        // Call the method under test
        Optional<Product> actualProduct = productService.getProductById(productId);
        Optional<Product> notFoundProduct = productService.getProductById(2L);

        // Verify the results for actual product
        assertTrue(actualProduct.isPresent());
        assertEquals(expectedProduct, actualProduct.get());

        // Verify the results for missing product
        assertFalse(notFoundProduct.isPresent());
        assertThrowsExactly(NoSuchElementException.class, notFoundProduct::get);
    }
}