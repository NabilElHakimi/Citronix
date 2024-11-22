
package me.elhakimi.citronix.rest.controller;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import me.elhakimi.citronix.domain.Harvest;
import me.elhakimi.citronix.rest.vm.HarvestVm;
import me.elhakimi.citronix.rest.vm.mapper.HarvestVmMapper;
import me.elhakimi.citronix.service.impl.HarvestServiceImpl;
import me.elhakimi.citronix.util.ResponseUtil;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/harvest")
@AllArgsConstructor
public class HarvestController {

        private final HarvestServiceImpl harvestService;
        private final HarvestVmMapper harvestVmMapper;

        @PostMapping
        public ResponseEntity<Object> save(@RequestBody @Valid HarvestVm harvest) {
           Harvest harvestToSave = harvestService.save(harvestVmMapper.toHarvest(harvest));
           if(harvestToSave == null) return ResponseUtil.saveFailed("Harvest");

           return ResponseUtil.saveSuccessfully("Harvest" , harvestVmMapper.toHarvestVm(harvestToSave));

        }

        @PutMapping
        public ResponseEntity<Object> update(@RequestBody HarvestVm harvest) {

            if(harvest.getId() == null) return ResponseUtil.notFound("Harvest");

            Harvest harvestToSave = harvestService.update(harvestVmMapper.toHarvest(harvest));
            if(harvestToSave == null) return ResponseUtil.notFound("Harvest");

            return ResponseUtil.updateSuccessfully("Harvest" , harvestVmMapper.toHarvestVm(harvestToSave));

        }

        @GetMapping
        public Page<HarvestVm> findAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {

            return harvestService.findAll(page, size).map(harvestVmMapper::toHarvestVm);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Object> findById(@PathVariable Long id) {

            if(id == null || id < 0 ) return ResponseUtil.notFound("Harvest");
            Harvest harvest = harvestService.findById(id);
            if(harvest == null) return ResponseUtil.notFound("Harvest");
            return ResponseUtil.getSuccessfully("Harvest", harvestService.findById(id));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Object> delete(@PathVariable Long id) {

            if(id == null || id < 0 ) return ResponseUtil.notFound("Harvest");
            Harvest harvest = harvestService.findById(id);
            if(harvest == null) return ResponseUtil.notFound("Harvest");
            harvestService.delete(id);
            return ResponseUtil.deleteSuccessfully("Harvest");

        }


}
