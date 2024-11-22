package me.elhakimi.citronix.service;

public interface CrudService<T> {
    public T save(T object);
    public T findById(Long id);
    public T update(T object);
    public void delete(Long id);
}