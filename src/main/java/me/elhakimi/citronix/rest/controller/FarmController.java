package me.elhakimi.citronix.rest.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import me.elhakimi.citronix.domain.Farm;
import me.elhakimi.citronix.rest.exception.exceptions.mustBeNotNullException;
import me.elhakimi.citronix.rest.exception.exceptions.mustBeNullException;
import me.elhakimi.citronix.domain.dto.mapper.FarmDtoMapper;
import me.elhakimi.citronix.rest.vm.FarmVm;
import me.elhakimi.citronix.rest.vm.mapper.FarmVmMapper;
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
    private final FarmDtoMapper farmDtoMapper;
    private final FarmVmMapper farmVmMapper;

    @GetMapping
    public ResponseEntity<Object> getFarm() {
        return ResponseEntity.ok(farmService.getFarms());
    }

    @PostMapping
    public ResponseEntity<Object> saveFarm(@RequestBody @Valid FarmVm farmVm) {

        if(farmVm.getId() != null) throw new mustBeNullException("Id");
//        if (!farmVm.getFields().isEmpty()) throw new mustBeNullException("Fields");
        return ResponseEntity.ok(farmVmMapper.toFarmVm(farmService.save(farmVmMapper.toFarm(farmVm))));
    }

    @PutMapping
    public ResponseEntity<Object> updateFarm(@RequestBody @Valid Farm farm) {
        if (farm.getId() == null) throw new mustBeNotNullException("Id");

        if (farmService.getFarm(farm.getId()) != null) {
            return ResponseEntity.ok(farmDtoMapper.toFarmVm(farmService.update(farm)));
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
