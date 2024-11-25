
package me.elhakimi.citronix.rest.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import me.elhakimi.citronix.domain.Sale;
import me.elhakimi.citronix.rest.vm.RequestVm.SaleRequest;
import me.elhakimi.citronix.rest.vm.RequestVm.mapper.SaleRequestMapper;
import me.elhakimi.citronix.rest.vm.SaleVm;
import me.elhakimi.citronix.rest.vm.ResponseVm.mapper.SaleVmMapper;
import me.elhakimi.citronix.service.interfaces.SaleService;
import me.elhakimi.citronix.util.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sale")
@AllArgsConstructor
public class SaleController {

    private final SaleService saleService;
    private final SaleVmMapper saleVmMapper;
    private final SaleRequestMapper saleRequestMapper ;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid SaleRequest saleRequest) {

        if(saleRequest.getId() != null) {
            return ResponseUtil.mustBeNullException("Id");
        }

        Sale savedSale = saleService.save(saleRequestMapper.toSale(saleRequest));
        return ResponseUtil.saveSuccessfully("Sale" , saleVmMapper.toSaleVm(savedSale));

    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody @Valid SaleRequest saleRequest) {

        if(saleRequest.getId() == null) {
            return ResponseUtil.mustBeNotNullException("Id");
        }

        Sale updatedSale = saleService.update(saleRequestMapper.toSale(saleRequest));
        return ResponseUtil.updateSuccessfully("Sale" , saleVmMapper.toSaleVm(updatedSale));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable  Long id) {
        Sale sale = saleService.findById(id);
        if(sale == null) {
            return ResponseUtil.notFound("Sale");
        }
        saleService.delete(sale.getId());
        return ResponseUtil.deleteSuccessfully("Sale");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {

        Sale saleToDelete = saleService.findById(id);

        if(saleToDelete == null) {
            return ResponseUtil.notFound("Sale");
        }
        saleService.delete(saleToDelete.getId());

        return ResponseUtil.deleteSuccessfully("Sale");
    }

}
