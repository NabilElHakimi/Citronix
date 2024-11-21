package me.elhakimi.citronix.rest.vm;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import me.elhakimi.citronix.domain.Harvest;
import me.elhakimi.citronix.domain.HarvestDetail;
import me.elhakimi.citronix.domain.Tree;
import me.elhakimi.citronix.domain.enums.Season;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
