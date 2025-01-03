package me.elhakimi.citronix.rest.vm.ResponseVm;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HarvestDetailForHarvestVm {

    private Long id;

    @PositiveOrZero
    private double quantity;

}
