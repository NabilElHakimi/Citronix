package me.elhakimi.citronix.rest.vm;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import me.elhakimi.citronix.domain.Farm;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class FieldVm {

    private Long id;
    private String name;

    @Min(value = 1000 , message = "Area must be greater than 1000 m²")
    private double area;
    private Long farmId;

    @JsonIgnore
    private List<TreeVm> trees = new ArrayList<>();


}