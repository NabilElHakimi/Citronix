package me.elhakimi.citronix.service.impl;


import lombok.AllArgsConstructor;
import me.elhakimi.citronix.Repository.FarmRepository;
import me.elhakimi.citronix.domain.Farm;
import me.elhakimi.citronix.rest.exception.farm.FieldMustBeNullException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FarmServiceImpl {

    private final FarmRepository farmRepository;


    public List<Farm> getFarms() {
        return farmRepository.findAll();
    }

    public Farm save(Farm farm) {
        if(farm.getFields() != null)  {
            throw new FieldMustBeNullException();
        }

        return farmRepository.save(farm);
    }


    public Farm getFarm(Long id) {
        return farmRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        farmRepository.deleteById(id);
    }


    public Farm update(Farm farm) {
        return farmRepository.save(farm);
    }





}
