package me.elhakimi.citronix.service.impl;

import lombok.AllArgsConstructor;
import me.elhakimi.citronix.Repository.FieldRepository;
import me.elhakimi.citronix.domain.Farm;
import me.elhakimi.citronix.domain.Field;
import me.elhakimi.citronix.rest.exception.exceptions.DontHaveAreaException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FieldServiceImpl {

    private final FieldRepository fieldRepository;
    private final FarmServiceImpl farmService ;

    public Field saveField(Field field , Long id) {

        Farm farm = farmService.getFarm(id);
        if(farm != null){
            double fieldsSum = fieldRepository.searchAllByFarm(farm).stream().mapToDouble(Field::getArea).sum();
            if((fieldsSum+field.getArea()) > farm.getArea())  throw new DontHaveAreaException();
            field.setFarm(farm);
            return fieldRepository.save(field);
        }
        return null ;
    }

    public Optional<Field> getField(Long fieldId) {
        return fieldRepository.findById(fieldId);
    }

    public Field updateField(Field field) {
        return fieldRepository.save(field);
    }

    public void deleteField(Long fieldId) {
        fieldRepository.deleteById(fieldId);
    }

}


