
package me.elhakimi.citronix.rest.controller;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import me.elhakimi.citronix.domain.Harvest;
import me.elhakimi.citronix.service.impl.HarvestServiceImpl;
import me.elhakimi.citronix.util.ResponseUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/harvest")
@AllArgsConstructor
public class HarvestController {

        private final HarvestServiceImpl harvestService;

        @PostMapping
        public ResponseEntity<Object> save(@RequestBody @Valid Harvest harvest) {
           Harvest harvestToSave = harvestService.save(harvest);
           if(harvestToSave == null) return ResponseUtil.saveFailed("Harvest");

           return ResponseUtil.saveSuccessfully("Harvest" , harvestToSave);

        }

        @PutMapping
        public Harvest update(@RequestBody Harvest harvest) {
            return harvestService.update(harvest);
        }

        @GetMapping
        public Page<Harvest> findAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
            return harvestService.findAll(page, size);
        }

        @GetMapping("/{id}")
        public Harvest findById(@PathVariable Long id) {
            return harvestService.findById(id);
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable Long id) {
            harvestService.delete(id);
        }
}
