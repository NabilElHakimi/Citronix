package me.elhakimi.citronix.service.impl;


import lombok.AllArgsConstructor;
import me.elhakimi.citronix.Repository.SaleRepository;
import me.elhakimi.citronix.domain.Harvest;
import me.elhakimi.citronix.domain.Sale;
import me.elhakimi.citronix.rest.exception.exceptions.NotFoundException;
import me.elhakimi.citronix.service.CrudService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SaleServiceImpl implements CrudService<Sale> {

    private final SaleRepository saleRepository;
    private final HarvestServiceImpl harvestService;

    @Override
    public Sale save(Sale sale) {

        Harvest harvest = harvestService.findById(sale.getHarvest().getId());
        if (harvest == null) throw new NotFoundException("Harvest not found");
        sale.setHarvest(harvest);

        return saleRepository.save(sale);
    }

    @Override
    public Sale findById(Long id) {
        return saleRepository.findById(id).orElse(null);
    }

    @Override
    public Sale update(Sale sale) {

        Harvest harvest = harvestService.findById(sale.getHarvest().getId());
        if (harvest == null) throw new NotFoundException("Harvest not found");
        sale.setHarvest(harvest);

        return saleRepository.save(sale);
    }

    @Override
    public void delete(Long id) {
        saleRepository.deleteById(id);
    }


}
