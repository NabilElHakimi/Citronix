package me.elhakimi.citronix.service.interfaces;


import me.elhakimi.citronix.domain.Harvest;
import me.elhakimi.citronix.domain.HarvestDetail;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface HarvestDetailService {
    Page<HarvestDetail> findAll(int page, int size);
    HarvestDetail  save(HarvestDetail harvest);
    HarvestDetail update(HarvestDetail harvest);
    void delete(Long id);
    HarvestDetail findById(Long id);
//    List<Harvest> searchAll(String name, Double area, String location, LocalDate creationDate, Long id);
}
