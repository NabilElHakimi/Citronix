package me.elhakimi.citronix.rest.vm;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import me.elhakimi.citronix.domain.Field;

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
