package com.prompo.knit.Service;

import com.prompo.knit.model.Product;
import com.prompo.knit.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return new ArrayList<>(productRepository.findAll());
    }
    public Product getProductById(Long productId){
        return productRepository.findById(productId).get();
    }
}
