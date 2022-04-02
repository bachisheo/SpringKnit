package com.prompo.knit.Dao;

import java.util.List;
import java.util.Optional;

public interface ICrudService<T> {
    Optional<T> find(Long id);
    void save(T model);
    void delete(T model);
    void update(T model);
    List<T> getAll();


}
