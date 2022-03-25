package com.prompo.knit.repository;
import com.prompo.knit.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * extend crud-repositoruy
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}
