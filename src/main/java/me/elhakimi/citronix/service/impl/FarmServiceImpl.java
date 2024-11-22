package me.elhakimi.citronix.service.impl;


import lombok.AllArgsConstructor;
import me.elhakimi.citronix.Repository.FarmRepository;
import me.elhakimi.citronix.domain.Farm;
import me.elhakimi.citronix.domain.Field;
import me.elhakimi.citronix.rest.exception.exceptions.DontHaveAreaException;
import me.elhakimi.citronix.rest.exception.exceptions.mustBeNullException;
import me.elhakimi.citronix.service.CrudService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class FarmServiceImpl implements CrudService<Farm> {

    private final FarmRepository farmRepository;



    public List<Farm> getFarms() {
        return farmRepository.findAll();
    }

    @Override
    public Farm save(Farm farm) {

        double areaSum = farm.getFields().stream().mapToDouble(Field::getArea).sum();
        if(areaSum > farm.getArea()) throw new DontHaveAreaException("Field");
        farm.getFields().forEach(field -> field.setFarm(farm));
        return farmRepository.save(farm);
    }


    @Override
    public Farm findById(Long id) {
        return farmRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        farmRepository.deleteById(id);
    }

    @Override
    public Farm update(Farm farm) {
        if(farm.getId() == null) throw new mustBeNullException("Id");
        return farmRepository.save(farm);
    }

//   ---------------------- ------- ---- searchAllByNameOrAreaOrCreationDateOrId ------------------------------------------------------

    public List<Farm> searchAll(String name, Double area, String location, LocalDate creationDate, Long id) {
        return farmRepository.searchAllByCriteria(name, area, creationDate, id, location);
    }


}
