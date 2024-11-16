package me.elhakimi.citronix.rest.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import me.elhakimi.citronix.domain.Farm;
import me.elhakimi.citronix.rest.exception.mustBeNotNullException;
import me.elhakimi.citronix.rest.exception.mustBeNullException;
import me.elhakimi.citronix.service.impl.FarmServiceImpl;
import me.elhakimi.citronix.util.ResponseUtil;
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

        if(farm.getId() != null) throw new mustBeNullException("Id");
        if (!farm.getFields().isEmpty()) throw new mustBeNullException("Fields");

        return ResponseEntity.ok(farmService.save(farm));

    }

    @PutMapping
    public ResponseEntity<Object> updateFarm(@RequestBody @Valid Farm farm) {

        if(farm.getId() != null) throw new mustBeNotNullException("Id");
        if (!farm.getFields().isEmpty()) throw new mustBeNullException("Fields");

        return ResponseEntity.ok(farmService.update(farm));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFarm(@PathVariable Long id) {

        if(farmService.getFarm(id) != null) {
            farmService.delete(id);
            return ResponseUtil.deleteSuccessfully("Farm");
        }

        return ResponseUtil.notFound("Farm");

    }

}
