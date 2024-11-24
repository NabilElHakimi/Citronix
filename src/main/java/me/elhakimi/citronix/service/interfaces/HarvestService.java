package me.elhakimi.citronix.service.interfaces;

import me.elhakimi.citronix.domain.Harvest;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface HarvestService {
    Page<Harvest> findAll(int page, int size);
    Harvest save(Harvest harvest);
    Harvest update(Harvest harvest);
    void delete(Long id);
    Harvest findById(Long id);
//    List<Harvest> searchAll(String name, Double area, String location, LocalDate creationDate, Long id);
}
