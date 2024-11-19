package me.elhakimi.citronix.rest.vm;

import lombok.Getter;
import lombok.Setter;
import me.elhakimi.citronix.domain.Harvest;
import me.elhakimi.citronix.domain.Tree;

@Getter
@Setter
public class HarvestDetailVm {

    private Long id;

    private double quantity;

//    private Harvest harvest;

    private TreeVm tree;

}
