package me.elhakimi.citronix.service.impl;


import lombok.AllArgsConstructor;
import me.elhakimi.citronix.Repository.HarvestRepository;
import me.elhakimi.citronix.domain.Harvest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HarvestServiceImpl {

    private final HarvestRepository harvestRepository;

    public List<Harvest> getHarvests(int page , int size) {
        return harvestRepository.findAll(Pageable.ofSize(size).withPage(page)).getContent();
    }

    public Harvest save(Harvest harvest) {
        if(harvest.getId() != null) {
            throw new IllegalArgumentException("Harvest id must be null");
        }

        if(harvest.getDetails() != null){
            harvest.getDetails().forEach(harvestDetail -> {
                harvestDetail.setHarvest(harvest);
            });
        }

        return harvestRepository.save(harvest);
    }

    public Harvest getHarvest(Long id) {
        return harvestRepository.findById(id)
                .orElse(null);
    }


    public void delete(Long id) {
        harvestRepository.deleteById(id);
    }

    public Harvest update(Harvest harvest) {
        return harvestRepository.save(harvest);
    }








}
