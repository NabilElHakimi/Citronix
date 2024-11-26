
package me.elhakimi.citronix.rest.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import me.elhakimi.citronix.domain.Tree;
import me.elhakimi.citronix.rest.vm.RequestVm.TreeRequest;
import me.elhakimi.citronix.rest.vm.RequestVm.mapper.TreeRequestMapper;
import me.elhakimi.citronix.rest.vm.ResponseVm.TreeResponse;
import me.elhakimi.citronix.rest.vm.ResponseVm.mapper.TreeVmMapper;
import me.elhakimi.citronix.service.interfaces.TreeService;
import me.elhakimi.citronix.util.ResponseUtil;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tree")
@AllArgsConstructor
public class TreeController {

    private final TreeService treeService;
    private final TreeVmMapper treeVmMapper;
    private final TreeRequestMapper treeRequestMapper ;

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody TreeRequest treeRequest) {

        if (treeRequest.getId() != null) return ResponseUtil.saveFailed("Tree");

        if (treeRequest.getFieldId() == null || treeRequest.getFieldId() <= 0)
            return ResponseUtil.saveFailed("Tree: Field");

        Tree tree = treeRequestMapper.toTree(treeRequest);

        Tree savedTree = treeService.save(tree);

        if (savedTree != null) {
            return ResponseUtil.saveSuccessfully("Tree", treeVmMapper.toTreeVm(savedTree));
        }

        return ResponseUtil.saveFailed("Tree");
    }


    @PutMapping
    public ResponseEntity<Object> update(@Valid @RequestBody TreeRequest treeRequest) {

        if (treeRequest.getId() == null) return ResponseUtil.notFound("Tree");

        if (treeRequest.getFieldId() == null || treeRequest.getFieldId() <= 0)
            return ResponseUtil.notFound("Tree: Field");

        Tree tree = treeRequestMapper.toTree(treeRequest);

        Tree updatedTree = treeService.update(tree);

        if (updatedTree != null) {
            return ResponseUtil.updateSuccessfully("Tree", treeVmMapper.toTreeVm(updatedTree));
        }

        return ResponseUtil.notFound("Tree");
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getTree(@PathVariable Long id) {
        Tree tree = treeService.findById(id);
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
        List<TreeResponse> trees = treePage.map(treeVmMapper::toTreeVm).getContent();

        return ResponseUtil.getSuccessfully("Trees", trees);
    }


}


