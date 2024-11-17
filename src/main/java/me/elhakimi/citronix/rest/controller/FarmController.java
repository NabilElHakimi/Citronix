package me.elhakimi.citronix.rest.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import me.elhakimi.citronix.domain.Farm;
import me.elhakimi.citronix.rest.exception.mustBeNotNullException;
import me.elhakimi.citronix.rest.exception.mustBeNullException;
import me.elhakimi.citronix.rest.vm.FarmVm;
import me.elhakimi.citronix.rest.vm.mapper.FarmMapper;
import me.elhakimi.citronix.service.impl.FarmServiceImpl;
import me.elhakimi.citronix.util.ResponseUtil;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/farm")
@AllArgsConstructor
public class FarmController {

    private final FarmServiceImpl farmService;
    private final FarmMapper FarmMapper;
    private final FarmMapper farmMapper;

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
        if (farm.getId() == null) throw new mustBeNotNullException("Id");

        if (farmService.getFarm(farm.getId()) != null) {
            return ResponseEntity.ok(farmMapper.toFarmVm(farmService.update(farm)));
        }

        return ResponseUtil.notFound("Farm");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFarm(@PathVariable Long id) {

        if(farmService.getFarm(id) != null) {
            farmService.delete(id);
            return ResponseUtil.deleteSuccessfully("Farm");
        }

        return ResponseUtil.notFound("Farm");

    }


    @GetMapping("/search")
    public ResponseEntity<Object> searchFarm(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double area,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate creationDate,
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String location
    ) {
        return ResponseEntity.ok(farmService.searchAll(name, area, location, creationDate, id));
    }



}
