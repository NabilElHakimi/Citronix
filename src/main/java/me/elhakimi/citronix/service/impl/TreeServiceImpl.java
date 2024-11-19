package me.elhakimi.citronix.service.impl;


import lombok.AllArgsConstructor;
import me.elhakimi.citronix.Repository.TreeRepository;
import me.elhakimi.citronix.domain.Field;
import me.elhakimi.citronix.domain.Tree;
import me.elhakimi.citronix.domain.dto.mapper.TreeDtoMapper;
import me.elhakimi.citronix.rest.exception.exceptions.NotFoundException;
import me.elhakimi.citronix.domain.dto.TreeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TreeServiceImpl {

    private final TreeRepository treeRepository;
    private final  FieldServiceImpl fieldService;
    private final TreeDtoMapper treeDtoMapper;

    public Tree save(TreeDTO tree) {

        Field field = fieldService.getField(tree.getFiledId())
                .orElseThrow(() -> new NotFoundException("Field") );
            Tree treeToSave = treeDtoMapper.toEntity(tree);
            treeToSave.setField(field);
            return treeRepository.save(treeToSave);

    }

    public Tree update(TreeDTO tree) {

        if(tree.getId() == null) {
            throw new NotFoundException("Tree");
        }

        if(!treeRepository.existsById(tree.getId())) {
            throw new NotFoundException("Tree");
        }

        Field field = fieldService.getField(tree.getFiledId())
                .orElseThrow(() -> new NotFoundException("Field") );

        Tree treeToSave = treeDtoMapper.toEntity(tree);
        treeToSave.setField(field);
        return treeRepository.save(treeToSave);

    }

    public Page<Tree> findAll(int page, int size) {

        page = page < 1 ? 0 : page - 1;

        Pageable pageable = PageRequest.of(page, size);
        return treeRepository.findAll(pageable);
    }

    public void delete(Long id) {

        if(id == null) throw new NotFoundException("Tree");
        if (id == 0) throw new NotFoundException("Tree");
        if(!treeRepository.existsById(id)) throw new NotFoundException("Tree");

        treeRepository.deleteById(id);
    }

    public Tree getTree(Long id) {
        return treeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Tree"));
    }

}
