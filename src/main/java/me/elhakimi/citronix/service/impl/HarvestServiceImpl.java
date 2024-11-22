package me.elhakimi.citronix.service.impl;


import lombok.AllArgsConstructor;
import me.elhakimi.citronix.Repository.HarvestRepository;
import me.elhakimi.citronix.domain.Harvest;
import me.elhakimi.citronix.domain.HarvestDetail;
import me.elhakimi.citronix.rest.exception.exceptions.NotFoundException;
import me.elhakimi.citronix.rest.exception.exceptions.YouCanOnlyHarvestOncePerSeason;
import me.elhakimi.citronix.service.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ThemeResolver;

import java.util.List;

@Service
@AllArgsConstructor
public class HarvestServiceImpl implements CrudService<Harvest> {

    private final HarvestRepository harvestRepository;

    @Override
    public Harvest save(Harvest harvest) {

        List<Harvest> harvestCheck = harvestRepository.findLastBySeason(harvest.getSeason());

        harvestCheck.forEach(harvest1 -> {
            if (harvest.getHarvestDate().getYear() == harvest1.getHarvestDate().getYear())
                throw new YouCanOnlyHarvestOncePerSeason();
        });

        return harvestRepository.save(harvest);
    }
    @Override
    public Harvest update(Harvest harvest) {

        Harvest existingHarvest = harvestRepository.findById(harvest.getId()).orElse(null);
        if (existingHarvest == null) throw new NotFoundException("Harvest");

        if(existingHarvest.getHarvestDate().getYear() != harvest.getHarvestDate().getYear()) {
            List<Harvest> harvestCheck = harvestRepository.findLastBySeason(harvest.getSeason());

            harvestCheck.forEach(harvest1 -> {
                if (harvest.getHarvestDate().getYear() == harvest1.getHarvestDate().getYear())
                    throw new YouCanOnlyHarvestOncePerSeason();
            });
        }

        return harvestRepository.save(harvest);
    }

//    @Override
    public Page<Harvest> findAll(int page, int size) {

        page = page < 1 ? 0 : page - 1;

        Pageable pageable = PageRequest.of(page, size);
        return harvestRepository.findAll(pageable);

    }

    @Override
    public Harvest findById(Long id) {
        return harvestRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        harvestRepository.deleteById(id);
    }

}

