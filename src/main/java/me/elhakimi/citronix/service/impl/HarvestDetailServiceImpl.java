package me.elhakimi.citronix.service.impl;

import lombok.AllArgsConstructor;
import me.elhakimi.citronix.Repository.HarvestDetailRepository;
import me.elhakimi.citronix.domain.Harvest;
import me.elhakimi.citronix.domain.HarvestDetail;
import me.elhakimi.citronix.domain.Tree;
import me.elhakimi.citronix.rest.exception.exceptions.DontHaveAreaException;
import me.elhakimi.citronix.rest.exception.exceptions.NotFoundException;
import me.elhakimi.citronix.service.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class HarvestDetailServiceImpl implements CrudService<HarvestDetail> {

    private final HarvestDetailRepository harvestDetailRepository;
    private final HarvestServiceImpl harvestService;
    private final TreeServiceImpl treeService;

    @Override
    public HarvestDetail save(HarvestDetail harvestDetail) {

        Harvest harvest = harvestService.findById(harvestDetail.getHarvest().getId());
        if (harvest == null)    throw new NotFoundException("Harvest");


        Tree tree = treeService.findById(harvestDetail.getTree().getId());
        if (tree == null)    throw new NotFoundException("Tree");

        double checkTotalQuantity = harvest.getDetails().stream().mapToDouble(HarvestDetail::getQuantity).sum();
        if (checkTotalQuantity + harvestDetail.getQuantity() > harvest.getTotalQuantity()) throw new DontHaveAreaException("Quantity");

        if(harvestDetail.getQuantity() < 1  ) throw new NotFoundException("Tree Quantity");

        return harvestDetailRepository.save(harvestDetail);
    }
    @Override
    public HarvestDetail update(HarvestDetail harvestDetail) {

        if(harvestDetail.getId() == null) throw new NotFoundException("Harvest Detail");

        Harvest harvest = harvestService.findById(harvestDetail.getHarvest().getId());

        if (harvest == null)    throw new NotFoundException("Harvest");

        Tree tree = treeService.findById(harvestDetail.getTree().getId());
        if (tree == null)    throw new NotFoundException("Tree");

        if(harvestDetail.getQuantity() < 1  ) throw new NotFoundException("Tree Quantity");

        return harvestDetailRepository.save(harvestDetail);

    }
    @Override
    public HarvestDetail findById(Long id) {
        return harvestDetailRepository.findById(id).orElse(null);
    }
    @Override
    public void delete(Long id) {
        harvestDetailRepository.deleteById(id);
    }

    public Page<HarvestDetail> findAll(int page, int size) {

        page = page < 1 ? 0 : page - 1;

        Pageable pageable = PageRequest.of(page, size);
        return harvestDetailRepository.findAll(pageable);
    }



}
