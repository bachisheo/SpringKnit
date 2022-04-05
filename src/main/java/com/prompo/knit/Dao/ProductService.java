package com.prompo.knit.Dao;

import com.prompo.knit.model.Product;
import com.prompo.knit.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ICrudService<Product>{
    @Autowired
    ProductRepository productRepository;

    @Override
    public Optional<Product> find(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product model) {
        productRepository.save(model);
    }

    @Override
    public void delete(Product model) {

    }

    @Override
    public void update(Product model) {
        productRepository.save(model);
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(productRepository.findAll());
    }
}
