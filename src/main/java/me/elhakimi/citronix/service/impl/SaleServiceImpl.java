package me.elhakimi.citronix.service.impl;


import lombok.AllArgsConstructor;
import me.elhakimi.citronix.Repository.SaleRepository;
import me.elhakimi.citronix.domain.Harvest;
import me.elhakimi.citronix.domain.Sale;
import me.elhakimi.citronix.rest.exception.exceptions.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SaleServiceImpl  {

    private final SaleRepository saleRepository;
    private final HarvestServiceImpl harvestService;


    public Sale save(Sale sale) {

        Harvest harvest = harvestService.findById(sale.getHarvest().getId());
        if (harvest == null) throw new NotFoundException("Harvest not found");
        sale.setHarvest(harvest);

        return saleRepository.save(sale);
    }


    public Sale findById(Long id) {
        return saleRepository.findById(id).orElse(null);
    }


    public Sale update(Sale sale) {

        Harvest harvest = harvestService.findById(sale.getHarvest().getId());
        if (harvest == null) throw new NotFoundException("Harvest not found");
        sale.setHarvest(harvest);

        return saleRepository.save(sale);
    }


    public void delete(Long id) {
        saleRepository.deleteById(id);
    }


    public Page<Sale> findAll(int page, int size) {
        return null;
    }


}
