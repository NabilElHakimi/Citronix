package me.elhakimi.citronix.service.impl;


import lombok.AllArgsConstructor;
import me.elhakimi.citronix.Repository.TreeRepository;
import me.elhakimi.citronix.domain.Field;
import me.elhakimi.citronix.domain.Tree;
import me.elhakimi.citronix.rest.exception.exceptions.NotFoundException;
import me.elhakimi.citronix.domain.dto.TreeDTO;
import me.elhakimi.citronix.domain.dto.mapper.TreeMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TreeServiceImpl {

    private final TreeRepository treeRepository;
    private final  FieldServiceImpl fieldService;
    private final TreeMapper treeMapper;

    public Tree save(TreeDTO tree) {

        Field field = fieldService.getField(tree.getFiledId())
                .orElseThrow(() -> new NotFoundException("Field") );
            Tree treeToSave = treeMapper.toEntity(tree);
            treeToSave.setField(field);
            return treeRepository.save(treeToSave);

    }

    public Tree update(TreeDTO tree) {

        Field field = fieldService.getField(tree.getFiledId())
                .orElseThrow(() -> new NotFoundException("Field") );
        Tree treeToSave = treeMapper.toEntity(tree);
        treeToSave.setField(field);
        return treeRepository.save(treeToSave);

    }

    public List<Tree> findAll() {
        return treeRepository.findAll();
    }



    public void delete(Long id) {
        treeRepository.deleteById(id);
    }




}
