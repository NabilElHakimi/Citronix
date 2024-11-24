package me.elhakimi.citronix.service.interfaces;

import me.elhakimi.citronix.domain.Sale;
import org.springframework.data.domain.Page;

public interface SaleService {
    Page<Sale> findAll(int page, int size);
    Sale save(Sale sale);
    Sale update(Sale sale);
    void delete(Long id);
    Sale findById(Long id);
}
