package me.elhakimi.citronix.service.impl;


import lombok.AllArgsConstructor;
import me.elhakimi.citronix.Repository.SaleRepository;
import me.elhakimi.citronix.domain.Sale;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SaleServiceImpl {

    private final SaleRepository saleRepository;

    public Sale save(Sale sale) {
        return saleRepository.save(sale);
    }

    public Sale findById(Long id) {
        return saleRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        saleRepository.deleteById(id);
    }

    public Sale update(Sale sale) {
        return saleRepository.save(sale);
    }




}
