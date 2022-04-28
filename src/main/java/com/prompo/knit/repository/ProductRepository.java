package com.prompo.knit.repository;
import com.prompo.knit.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *  Интерфейс репозитория для таблицы продуктов.
 *  Класс репозитория будет сгенерирован автоматически
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findProductsByName(String Name);

}
