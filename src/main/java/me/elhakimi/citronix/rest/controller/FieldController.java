
package me.elhakimi.citronix.rest.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import me.elhakimi.citronix.domain.Field;
import me.elhakimi.citronix.rest.vm.FieldVm;
import me.elhakimi.citronix.rest.vm.mapper.FieldVmMapper;
import me.elhakimi.citronix.service.impl.FieldServiceImpl;
import me.elhakimi.citronix.service.interfaces.FieldService;
import me.elhakimi.citronix.util.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/field")
@AllArgsConstructor
public class FieldController {

    private final FieldService fieldService;
    private FieldVmMapper fieldVmMapper;

    @PostMapping
    public ResponseEntity<Object> saveField(@Valid @RequestBody FieldVm fieldVm) {

        if(fieldVm.getId() != null) return ResponseUtil.saveFailed("Field");
        if(fieldVm.getArea() < 0.1) return ResponseUtil.saveFailed("Field: Area");
        if(fieldVm.getFarmId() == null || fieldVm.getFarmId() <= 0 )  return ResponseUtil.saveFailed("Field: Farm");

        Field savedField = fieldService.save(fieldVmMapper.toField(fieldVm));

        return savedField != null
                ? ResponseUtil.saveSuccessfully("Field", fieldVmMapper.toFieldVm(savedField))
                : ResponseUtil.saveFailed("Field");
    }

    @PutMapping
    public ResponseEntity<Object> updateField(@Valid @RequestBody FieldVm fieldVm) {

        if(fieldVm.getId() == null || fieldVm.getId() <= 0) return ResponseUtil.notFound("Field");
        if(fieldVm.getArea() < 0.1) return ResponseUtil.notFound("Field: Area");
        if(fieldVm.getFarmId() == null || fieldVm.getFarmId() <= 0 )  return ResponseUtil.notFound("Field: Farm");

        Field updatedField = fieldService.update(fieldVmMapper.toField(fieldVm));

        return updatedField != null
                ? ResponseUtil.updateSuccessfully("Field", fieldVmMapper.toFieldVm(updatedField))
                : ResponseUtil.notFound("Field");
    }

    @DeleteMapping("/{fieldId}")
    public ResponseEntity<Object> deleteField(@PathVariable Long fieldId) {

        if(fieldId == null || fieldId <= 0) return ResponseUtil.notFound("Field");

        fieldService.delete(fieldId);

        return ResponseUtil.deleteSuccessfully("Field");
    }


}
