package me.elhakimi.citronix.service.interfaces;

import me.elhakimi.citronix.domain.Farm;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface FarmService {
    Page<Farm> findAll(int page, int size);
    Farm save(Farm farm);
    Farm update(Farm farm);
    void delete(Long id);
    Farm findById(Long id);
    List<Farm> searchAll(String name, Double area, String location, LocalDate creationDate, Long id);
}