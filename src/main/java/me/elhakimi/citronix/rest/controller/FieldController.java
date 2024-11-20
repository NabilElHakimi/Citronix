
package me.elhakimi.citronix.rest.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import me.elhakimi.citronix.domain.Field;
import me.elhakimi.citronix.rest.vm.FieldVm;
import me.elhakimi.citronix.rest.vm.mapper.FieldVmMapper;
import me.elhakimi.citronix.service.impl.FieldServiceImpl;
import me.elhakimi.citronix.util.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/field")
@AllArgsConstructor
public class FieldController {

    private final FieldServiceImpl fieldService;
    private FieldVmMapper fieldVmMapper;

    @PostMapping
    public ResponseEntity<Object> saveField(@Valid @RequestBody FieldVm fieldVm, @RequestParam Long id) {

        Field savedField = fieldService.saveField(fieldVmMapper.toField(fieldVm), id);

        return savedField != null
                ? ResponseUtil.saveSuccessfully("Field", fieldVmMapper.toFieldVm(savedField))
                : ResponseUtil.saveFailed("Field");
    }


}
