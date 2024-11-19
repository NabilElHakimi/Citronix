
package me.elhakimi.citronix.rest.controller;


import lombok.AllArgsConstructor;
import me.elhakimi.citronix.domain.Harvest;
import me.elhakimi.citronix.rest.vm.HarvestVm;
import me.elhakimi.citronix.rest.vm.mapper.HarvestVmMapper;
import me.elhakimi.citronix.service.impl.HarvestServiceImpl;
import me.elhakimi.citronix.util.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/harvest")
@AllArgsConstructor
public class HarvestController {

    private final HarvestServiceImpl harvestService;
    private final HarvestVmMapper harvestVmMapper;

    public List<Harvest> getHarvests(int page , int size) {
        return harvestService.getHarvests(page, size);
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Harvest harvest) {
            HarvestVm harvestVm = harvestVmMapper.toHarvestVm(harvestService.save(harvest));
            return ResponseUtil.saveSuccessfully("Harvest" , harvestVm);
    }

    public Harvest getHarvest(Long id) {
        return harvestService.getHarvest(id);
    }

    public void delete(Long id) {
        harvestService.delete(id);
    }

    public Harvest update(Harvest harvest) {
        return harvestService.update(harvest);
    }


}
