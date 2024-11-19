package me.elhakimi.citronix.service.impl;


import lombok.AllArgsConstructor;
import me.elhakimi.citronix.Repository.HarvestRepository;
import me.elhakimi.citronix.domain.Harvest;
import me.elhakimi.citronix.domain.dto.HarvestDTO;
import me.elhakimi.citronix.domain.dto.mapper.HarvestDtoMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HarvestServiceImpl {

    private final HarvestRepository harvestRepository;
    private final HarvestDtoMapper harvestMapper;

    public List<Harvest> getHarvests(int page , int size) {
        return harvestRepository.findAll(Pageable.ofSize(size).withPage(page)).getContent();
    }

    public HarvestDTO save(HarvestDTO harvestDto) {

        if (harvestDto.getId() != null) {
            throw new IllegalArgumentException("Harvest id must be null");
        }

        Harvest harvest = harvestMapper.toHarvest(harvestDto);

        if (harvestDto.getDetails() != null) {
            harvestDto.getDetails().forEach(harvestDetail -> {
                harvestDetail.setHarvest(harvest);
            });
        }

        Harvest savedHarvest = harvestRepository.save(harvest);
        return harvestMapper.toHarvestDto(savedHarvest);
    }

    public Harvest getHarvest(Long id) {
        return harvestRepository.findById(id)
                .orElse(null);
    }


    public void delete(Long id) {
        harvestRepository.deleteById(id);
    }

    public HarvestDTO  update(HarvestDTO harvestDto) {
        if (harvestDto.getId() == null) {
            throw new IllegalArgumentException("Harvest id must not be null");
        }

        Harvest harvest = harvestMapper.toHarvest(harvestDto);

        if (harvestDto.getDetails() != null) {
            harvestDto.getDetails().forEach(harvestDetail -> {
                harvestDetail.setHarvest(harvest);
            });
        }

        Harvest savedHarvest = harvestRepository.save(harvest);
        return harvestMapper.toHarvestDto(savedHarvest);

    }








}
