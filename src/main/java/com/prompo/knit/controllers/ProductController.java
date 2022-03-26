package com.prompo.knit.controllers;

import com.prompo.knit.Service.ProductService;
import com.prompo.knit.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/a")
    private List<Product> getAllProduct(){
        return productService.getAllProducts();
    }
}
