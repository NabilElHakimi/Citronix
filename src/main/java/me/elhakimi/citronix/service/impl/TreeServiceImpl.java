package me.elhakimi.citronix.service.impl;


import lombok.AllArgsConstructor;
import me.elhakimi.citronix.Repository.TreeRepository;
import me.elhakimi.citronix.domain.Field;
import me.elhakimi.citronix.domain.Tree;
import me.elhakimi.citronix.rest.exception.exceptions.NotFoundException;
import me.elhakimi.citronix.rest.exception.exceptions.YouCantAddMoreTreesToThisField;
import me.elhakimi.citronix.rest.exception.exceptions.mustBeNotNullException;
import me.elhakimi.citronix.rest.exception.exceptions.mustBeNullException;
import me.elhakimi.citronix.service.interfaces.TreeService;
import me.elhakimi.citronix.util.CheckDateForPlantation;
import org.hibernate.validator.internal.engine.messageinterpolation.parser.MessageDescriptorFormatException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TreeServiceImpl implements TreeService {

    private final TreeRepository treeRepository;
    private final  FieldServiceImpl fieldService;

    @Override
    public Tree save(Tree tree) {

        if(tree.getId() != null) throw new mustBeNullException("Tree");

        if(tree.getField() == null)      throw new NotFoundException("Field");

        if (!CheckDateForPlantation.CheckDateIfBetweenMarshAndMai(tree.getPlantingDate())) {
            throw new MessageDescriptorFormatException("You can only plant trees between March and May");
        }

        Field field = checkFieldIfExist(tree.getField().getId());

        double treesNumber = field.getArea()/100 ;

        if(field.getTrees().size() >= treesNumber)   throw new YouCantAddMoreTreesToThisField();

        tree.setField(field);
        return treeRepository.save(tree);
    }

    @Override
    public Tree update(Tree tree) {

        if(tree.getId() == null) throw new mustBeNotNullException("Tree");

        if(!treeRepository.existsById(tree.getId())) throw new NotFoundException("Tree");

        if (!CheckDateForPlantation.CheckDateIfBetweenMarshAndMai(tree.getPlantingDate())) {
            throw new MessageDescriptorFormatException("You can only plant trees between March and May");
        }


        if(tree.getField() == null) throw new NotFoundException("Field");

        Field field = checkFieldIfExist(tree.getField().getId());

        double treesNumber = field.getArea()/100 ;

        if(field.getTrees().size() >= treesNumber) {
            throw new YouCantAddMoreTreesToThisField();
        }

        tree.setField(field);
        return treeRepository.save(tree);
    }

    public Page<Tree> findAll(int page, int size) {

        page = page < 1 ? 0 : page - 1;

        Pageable pageable = PageRequest.of(page, size);
        return treeRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {

        if(id == null) throw new NotFoundException("Tree");
        if (id == 0) throw new NotFoundException("Tree");
        if(!treeRepository.existsById(id)) throw new NotFoundException("Tree");

        treeRepository.deleteById(id);
    }

    @Override
    public Tree findById(Long id) {
        return treeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Tree"));
    }


    private Field checkFieldIfExist(Long fieldId) {
        Field field = fieldService.findById(fieldId) ;
        if (field == null)  throw new NotFoundException("Field");
        return field;
    }

}
