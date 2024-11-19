
package me.elhakimi.citronix.rest.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import me.elhakimi.citronix.domain.Field;
import me.elhakimi.citronix.service.impl.FieldServiceImpl;
import me.elhakimi.citronix.util.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/field")
@AllArgsConstructor
public class FieldController {

    private final FieldServiceImpl fieldService;

    @PostMapping
    public ResponseEntity<Object> saveField(@Valid  @RequestBody Field field , @RequestParam Long id) {
        if(fieldService.saveField(field , id) != null) {
            return ResponseUtil.saveSuccessfully("Field" , field);
        } else {
            return ResponseUtil.saveFailed("Field");
        }
    }

}
