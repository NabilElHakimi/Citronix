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

    public Harvest save(Harvest harvest) {
        return harvestRepository.save(harvest);
    }

    public List<Harvest> findAll(Pageable pageable) {
        return harvestRepository.findAll(pageable).getContent();
    }

    public Harvest findById(Long id) {
        return harvestRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        harvestRepository.deleteById(id);
    }

    public Harvest update(Harvest harvest) {
        return harvestRepository.save(harvest);
    }

    }

