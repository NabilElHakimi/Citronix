package me.elhakimi.citronix.service.impl;


import lombok.AllArgsConstructor;
import me.elhakimi.citronix.Repository.HarvestDetailRepository;
import me.elhakimi.citronix.domain.Harvest;
import me.elhakimi.citronix.domain.HarvestDetail;
import me.elhakimi.citronix.domain.Tree;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HarvestDetailServiceImpl {

    private final HarvestDetailRepository harvestDetailRepository;

    public HarvestDetail save(HarvestDetail harvestDetail) {
        return harvestDetailRepository.save(harvestDetail);
    }

    public HarvestDetail findById(Long id) {
        return harvestDetailRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        harvestDetailRepository.deleteById(id);
    }

    public HarvestDetail update(HarvestDetail harvestDetail) {
        return harvestDetailRepository.save(harvestDetail);
    }

    public Page<HarvestDetail> findAll(int page, int size) {

        page = page < 1 ? 0 : page - 1;

        Pageable pageable = PageRequest.of(page, size);
        return harvestDetailRepository.findAll(pageable);
    }



}
