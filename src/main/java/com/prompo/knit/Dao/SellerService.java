package com.prompo.knit.Dao;

import com.prompo.knit.model.Seller;
import com.prompo.knit.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SellerService implements ICrudService<Seller>{
    /** Инъекция зависимости от репозитория таблицы */
    @Autowired
    SellerRepository sellerRepository;

    public Seller findByLogin(String login) {
        return sellerRepository.findAll().stream()
                .filter(x -> x.getLogin().equals(login)).findFirst().get();
    }

    @Override
    public Optional<Seller> find(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Seller model) {

    }

    @Override
    public void delete(Seller model) {

    }

    @Override
    public List<Seller> getAll() {
        return null;
    }
}
