
package me.elhakimi.citronix.rest.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import me.elhakimi.citronix.domain.HarvestDetail;
import me.elhakimi.citronix.rest.vm.HarvestDetailVm;
import me.elhakimi.citronix.rest.vm.HarvestVm;
import me.elhakimi.citronix.rest.vm.mapper.HarvestDetailVmMapper;
import me.elhakimi.citronix.service.impl.HarvestDetailServiceImpl;
import me.elhakimi.citronix.util.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/harvest-detail")
@AllArgsConstructor
public class HarvestDetailController {

    private final HarvestDetailServiceImpl harvestDetailService;
    private final HarvestDetailVmMapper harvestDetailVmMapper;

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody HarvestDetailVm harvestDetailVm) {

        if (harvestDetailVm.getQuantity() < 1) {
            return ResponseUtil.notFound("Tree Quantity");
        }
        if(harvestDetailVm.getHarvestId() == null) {
            return ResponseUtil.notFound("Harvest");
        }
        if(harvestDetailVm.getTreeId() == null) {
            return ResponseUtil.notFound("Tree");
        }

        HarvestDetail harvestDetail = harvestDetailVmMapper.toHarvestDetail(harvestDetailVm);
         if(harvestDetailService.save(harvestDetail) != null) {
            return ResponseUtil.saveSuccessfully("Harvest Detail" , harvestDetailVmMapper.toHarvestDetailVm(harvestDetail));
    }
        return ResponseUtil.saveFailed("Harvest Detail");
    }

}
