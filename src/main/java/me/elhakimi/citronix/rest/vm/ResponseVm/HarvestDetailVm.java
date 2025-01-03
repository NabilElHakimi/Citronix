package me.elhakimi.citronix.rest.vm.ResponseVm;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HarvestDetailVm {

    private Long id;

    @PositiveOrZero
    private double quantity;

    private Long harvestId;

    private Long treeId;

}
