package me.elhakimi.citronix.service.impl;


import lombok.AllArgsConstructor;
import me.elhakimi.citronix.Repository.FarmRepository;
import me.elhakimi.citronix.domain.Farm;
import me.elhakimi.citronix.rest.exception.mustBeNullException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class FarmServiceImpl {

    private final FarmRepository farmRepository;


    public List<Farm> getFarms() {
        return farmRepository.findAll();
    }

    public Farm save(Farm farm) {
        return farmRepository.save(farm);
    }

    public Farm getFarm(Long id) {
        return farmRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        farmRepository.deleteById(id);
    }


    public Farm update(Farm farm) {
        if(farm.getId() == null) throw new mustBeNullException("Id");
        return farmRepository.save(farm);
    }

//   ---------------------- ------- ---- searchAllByNameOrAreaOrCreationDateOrId ------------------------------------------------------

    public List<Farm> searchAll(String name, Double area, String location, LocalDate creationDate, Long id) {
        return farmRepository.searchAllByCriteria(name, area, creationDate, id, location);
    }


}
