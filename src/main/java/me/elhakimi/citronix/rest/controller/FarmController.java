package me.elhakimi.citronix.rest.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import me.elhakimi.citronix.rest.exception.exceptions.mustBeNotNullException;
import me.elhakimi.citronix.rest.exception.exceptions.mustBeNullException;
import me.elhakimi.citronix.rest.vm.FarmVm;
import me.elhakimi.citronix.rest.vm.mapper.FarmVmMapper;
import me.elhakimi.citronix.service.impl.FarmServiceImpl;
import me.elhakimi.citronix.service.interfaces.FarmService;
import me.elhakimi.citronix.util.ResponseUtil;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/farm")
@AllArgsConstructor

public class FarmController {


    private final FarmService farmService;
    private final FarmVmMapper farmVmMapper;



    @GetMapping
    public ResponseEntity<Object> findAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size) {
        Page<FarmVm> farmVmPage = farmService.findAll(page, size).map(farmVmMapper::toFarmVm);
        return ResponseEntity.ok(farmVmPage);

    }

    @PostMapping
    public ResponseEntity<Object> saveFarm(@RequestBody @Valid FarmVm farmVm) {

        if(farmVm.getId() != null) throw new mustBeNullException("Id");
//        if (!farmVm.getFields().isEmpty()) throw new mustBeNullException("Fields");
        return ResponseEntity.ok(farmVmMapper.toFarmVm(farmService.save(farmVmMapper.toFarm(farmVm))));
    }

    @PutMapping
    public ResponseEntity<Object> updateFarm(@RequestBody @Valid FarmVm farmVm) {
        if (farmVm.getId() == null) throw new mustBeNotNullException("Id");

        if (farmService.findById(farmVm.getId()) != null) {
            return ResponseEntity.ok(farmVmMapper.toFarmVm(farmService.update(farmVmMapper.toFarm(farmVm))));
        }

        return ResponseUtil.notFound("Farm");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFarm(@PathVariable Long id) {

        if(farmService.findById(id) != null) {
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
        return ResponseEntity.ok(farmVmMapper.toFarmVmList(farmService.searchAll(name, area, location, creationDate, id)));
    }

}
