
package me.elhakimi.citronix.rest.controller;


import lombok.AllArgsConstructor;
import me.elhakimi.citronix.domain.Sale;
import me.elhakimi.citronix.rest.vm.SaleVm;
import me.elhakimi.citronix.rest.vm.mapper.SaleVmMapper;
import me.elhakimi.citronix.service.impl.SaleServiceImpl;
import me.elhakimi.citronix.util.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sale")
@AllArgsConstructor
public class SaleController {

    private final SaleServiceImpl saleService;
    private final SaleVmMapper saleVmMapper;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody SaleVm saleVm) {

        if(saleVm.getId() != null) {
            return ResponseUtil.mustBeNullException("Id");
        }

        Sale savedSale = saleService.save(saleVmMapper.toSale(saleVm));
        return ResponseUtil.saveSuccessfully("Sale" , saleVmMapper.toSaleVm(savedSale));

    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody SaleVm saleVm) {

        if(saleVm.getId() == null) {
            return ResponseUtil.mustBeNullException("Id");
        }

        Sale updatedSale = saleService.update(saleVmMapper.toSale(saleVm));
        return ResponseUtil.updateSuccessfully("Sale" , saleVmMapper.toSaleVm(updatedSale));

    }

}
