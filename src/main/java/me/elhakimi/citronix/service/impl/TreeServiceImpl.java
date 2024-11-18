package me.elhakimi.citronix.service.impl;


import lombok.AllArgsConstructor;
import me.elhakimi.citronix.Repository.TreeRepository;
import me.elhakimi.citronix.domain.Tree;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TreeServiceImpl {

    private final TreeRepository treeRepository;

    public Tree save(Tree tree) {
        return treeRepository.save(tree);
    }

    public List<Tree> findAll() {
        return treeRepository.findAll();
    }

    public Tree update(Tree tree) {
        return  treeRepository.save(tree);
    }

    public void delete(Long id) {
        treeRepository.deleteById(id);
    }




}
