
package me.elhakimi.citronix.rest.controller;


import lombok.AllArgsConstructor;
import me.elhakimi.citronix.domain.Harvest;
import me.elhakimi.citronix.domain.dto.HarvestDTO;
import me.elhakimi.citronix.rest.vm.HarvestVm;
import me.elhakimi.citronix.rest.vm.mapper.HarvestVmMapper;
import me.elhakimi.citronix.service.impl.HarvestServiceImpl;
import me.elhakimi.citronix.util.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Object> save(@RequestBody HarvestDTO harvestDto) {
        HarvestDTO savedHarvest = harvestService.save(harvestDto);
        HarvestVm harvestVm = harvestVmMapper.toHarvestVm(savedHarvest);
        return ResponseUtil.saveSuccessfully("Harvest", harvestVm);
    }

    public Harvest getHarvest(Long id) {
        return harvestService.getHarvest(id);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        if(harvestService.getHarvest(id) != null) {
            harvestService.delete(id);
            return ResponseUtil.deleteSuccessfully("Harvest");
        }

        return ResponseUtil.notFound("Harvest");

    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody  HarvestDTO harvestDto) {
        HarvestDTO updatedHarvest = harvestService.update(harvestDto);
        HarvestVm harvestVm = harvestVmMapper.toHarvestVm(updatedHarvest);
        return ResponseUtil.updateSuccessfully("Harvest", harvestVm);
    }
}
