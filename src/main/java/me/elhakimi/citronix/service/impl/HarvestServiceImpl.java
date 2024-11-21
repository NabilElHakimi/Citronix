package me.elhakimi.citronix.service.impl;


import lombok.AllArgsConstructor;
import me.elhakimi.citronix.Repository.HarvestRepository;
import me.elhakimi.citronix.domain.Harvest;
import me.elhakimi.citronix.domain.HarvestDetail;
import me.elhakimi.citronix.rest.exception.exceptions.NotFoundException;
import me.elhakimi.citronix.rest.exception.exceptions.YouCanOnlyHarvestOncePerSeason;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ThemeResolver;

import java.util.List;

@Service
@AllArgsConstructor
public class HarvestServiceImpl {

    private final HarvestRepository harvestRepository;

    public Harvest save(Harvest harvest) {

        Harvest harvestCheck = harvestRepository.findLastBySeason(harvest.getSeason());

        if (harvestCheck != null && harvest.getHarvestDate().getYear() == harvestCheck.getHarvestDate().getYear())
            throw new YouCanOnlyHarvestOncePerSeason();

        return harvestRepository.save(harvest);
    }

    public Harvest update(Harvest harvest) {

        Harvest harvestCheck = harvestRepository.findById(harvest.getId()).orElse(null);
        if(harvestCheck == null) throw new NotFoundException("Harvest");

        if(harvest.getSeason() != null && harvestCheck.getSeason() != harvest.getSeason()){
            Harvest harvestCheckSeason = harvestRepository.findLastBySeason(harvest.getSeason());
            if (harvestCheckSeason != null && harvest.getHarvestDate().getYear() == harvestCheckSeason.getHarvestDate().getYear())
                throw new YouCanOnlyHarvestOncePerSeason();
        }

        return harvestRepository.save(harvest);
    }

    public Page<Harvest> findAll(int page, int size) {

        page = page < 1 ? 0 : page - 1;

        Pageable pageable = PageRequest.of(page, size);
        return harvestRepository.findAll(pageable);
    }

    public Harvest findById(Long id) {
        return harvestRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        harvestRepository.deleteById(id);
    }







    }

