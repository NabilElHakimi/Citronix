package me.elhakimi.citronix.service;

import org.springframework.data.domain.Page;

public interface CrudService<T> {
     T save(T object);
     T findById(Long id);
     T update(T object);
     void delete(Long id);
     Page<T> findAll(int page, int size);
}