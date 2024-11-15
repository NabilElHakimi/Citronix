package me.elhakimi.citronix.rest.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/farm")
@AllArgsConstructor
public class FarmController {

    @GetMapping
    public String getFarm() {
        return "Farm";
    }

}
