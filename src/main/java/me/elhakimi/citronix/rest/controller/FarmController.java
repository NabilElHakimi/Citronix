package me.elhakimi.citronix.rest.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import me.elhakimi.citronix.domain.Farm;
import me.elhakimi.citronix.service.impl.FarmServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/farm")
@AllArgsConstructor
public class FarmController {

    private final FarmServiceImpl farmService;

    @GetMapping
    public ResponseEntity<Object> getFarm() {
        return ResponseEntity.ok(farmService.getFarms());
    }

    @PostMapping
    public ResponseEntity<Object> saveFarm(@RequestBody @Valid Farm farm) {
        return ResponseEntity.ok(farmService.save(farm));
    }

    @PutMapping
    public ResponseEntity<Object> updateFarm() {
        return ResponseEntity.ok(farmService.update(null));
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteFarm(@RequestParam Long id) {
        farmService.delete(id);
        return ResponseEntity.ok("{message: Farm deleted}");
    }



}
