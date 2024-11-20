package me.elhakimi.citronix.rest.vm;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class FarmVm {

    private Long id;
    private String name;
    private String location;
    private double area;
    private LocalDate creationDate;
    private List<FieldVm> fields = new ArrayList<>();

}