
package me.elhakimi.citronix.rest.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import me.elhakimi.citronix.domain.Tree;
import me.elhakimi.citronix.service.impl.TreeServiceImpl;
import me.elhakimi.citronix.util.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tree")
@AllArgsConstructor
public class TreeController {

    private final TreeServiceImpl treeService;

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody Tree tree) {
        Tree savedTree = treeService.save(tree);
        if (savedTree != null) {
            return ResponseUtil.saveSuccessfully("Tree", savedTree);
        }
        return ResponseUtil.saveFailed("Tree");
    }

}



