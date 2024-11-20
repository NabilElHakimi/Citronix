
package me.elhakimi.citronix.rest.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import me.elhakimi.citronix.domain.Field;
import me.elhakimi.citronix.domain.Tree;
import me.elhakimi.citronix.domain.dto.TreeDTO;
import me.elhakimi.citronix.rest.vm.TreeVm;
import me.elhakimi.citronix.rest.vm.mapper.TreeVmMapper;
import me.elhakimi.citronix.service.impl.TreeServiceImpl;
import me.elhakimi.citronix.util.ResponseUtil;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tree")
@AllArgsConstructor
public class TreeController {

    private final TreeServiceImpl treeService;
    private final TreeVmMapper treeVmMapper;

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody TreeVm treeVm) {

        if (treeVm.getId() != null) return ResponseUtil.saveFailed("Tree");

        if (treeVm.getField() == null || treeVm.getField().getId() == null)
            return ResponseUtil.saveFailed("Tree: Field");

        Tree tree = treeVmMapper.toTree(treeVm);
        Field field = new Field();
        field.setId(treeVm.getField().getId());
        tree.setField(field);

        Tree savedTree = treeService.save(tree);

        if (savedTree != null) {
            return ResponseUtil.saveSuccessfully("Tree", treeVmMapper.toTreeVm(savedTree));
        }

        return ResponseUtil.saveFailed("Tree");
    }




    @PutMapping
    public ResponseEntity<Object> update(@Valid @RequestBody TreeDTO tree) {
        Tree updatedTree = treeService.update(tree);
        if (updatedTree != null) {
            return ResponseUtil.updateSuccessfully("Tree", treeVmMapper.toTreeVm(updatedTree));
        }

        return ResponseUtil.notFound("Tree");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTree(@PathVariable Long id) {
        Tree tree = treeService.getTree(id);
        if (tree != null) {
            return ResponseUtil.getSuccessfully("Tree", treeVmMapper.toTreeVm(tree));
        }

        return ResponseUtil.notFound("Tree");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        treeService.delete(id);
        return ResponseUtil.deleteSuccessfully("Tree");
    }


    @GetMapping
    public ResponseEntity<Object> findAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<Tree> treePage = treeService.findAll(page, size);
        List<TreeVm> trees = treePage.map(treeVmMapper::toTreeVm).getContent();

        return ResponseUtil.getSuccessfully("Trees", trees);
    }


}


