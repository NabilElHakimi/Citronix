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

    @ManyToOne
    @JoinColumn(name = "harvest_id")
    private Long harvestId;

    @ManyToOne
    @JoinColumn(name = "tree_id")
    private Long treeId;

}
