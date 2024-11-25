package me.elhakimi.citronix.rest.vm.RequestVm;

import lombok.Getter;
import lombok.Setter;
import me.elhakimi.citronix.rest.vm.FieldVm;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class FarmRequest {

    private Long id;
    private String name;
    private String location;
    private double area;
    private LocalDate creationDate;

}