package me.elhakimi.citronix.service.interfaces;

import me.elhakimi.citronix.domain.Field;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface FieldService {
    Page<Field> findAll(int page, int size);
    Field save(Field field);
    Field update(Field field);
    void delete(Long id);
    Field findById(Long id);
//    List<Field> searchAll(String name, Double area, String location, LocalDate creationDate, Long id);
}