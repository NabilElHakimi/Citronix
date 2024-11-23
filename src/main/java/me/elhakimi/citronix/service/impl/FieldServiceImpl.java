package me.elhakimi.citronix.service.impl;

import lombok.AllArgsConstructor;
import me.elhakimi.citronix.Repository.FieldRepository;
import me.elhakimi.citronix.domain.Farm;
import me.elhakimi.citronix.domain.Field;
import me.elhakimi.citronix.rest.exception.exceptions.DontHaveAreaException;
import me.elhakimi.citronix.rest.exception.exceptions.NotFoundException;
import me.elhakimi.citronix.rest.exception.exceptions.mustBeNotNullException;
import me.elhakimi.citronix.service.interfaces.FieldService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FieldServiceImpl implements FieldService {

    private final FieldRepository fieldRepository;
    private final FarmServiceImpl farmService ;


    public Field save(Field field) {

        Farm farm = farmService.findById(field.getFarm().getId());
        if(farm != null){
                if(CheckFieldArea(farm,field)) return fieldRepository.save(field);
        }
        return null ;
    }


    public Field findById(Long fieldId) {
        return fieldRepository.findById(fieldId).orElse(null);
    }


    public Field update(Field field) {

        if(field.getId() == null || field.getId() < 1 ) throw new mustBeNotNullException("Field");

        if(!fieldRepository.existsById(field.getId())  ) throw new NotFoundException("Field");

        Farm farm = farmService.findById(field.getFarm().getId());

        if(farm != null){
            if(CheckFieldArea(farm,field))   return fieldRepository.save(field);
        }
        return fieldRepository.save(field);
    }


    public void delete(Long fieldId) {
        if(fieldId == null || fieldId < 1 ) throw new mustBeNotNullException("Field");

        if(fieldRepository.existsById(fieldId)) fieldRepository.deleteById(fieldId);

    }


    public Page<Field> findAll(int page, int size) {
        return null;
    }


    private boolean CheckFieldArea(Farm farm, Field field) {

        if(farm.getFields().size() == 10 ) throw new DontHaveAreaException("Field");
        if(field.getArea() > farm.getArea()/2 ) throw new DontHaveAreaException("Field");
        double fieldsSum = fieldRepository.searchAllByFarm(farm).stream().mapToDouble(Field::getArea).sum();
        if((fieldsSum+field.getArea()) > farm.getArea())  throw new DontHaveAreaException("Field");
        return true;
    }

}


