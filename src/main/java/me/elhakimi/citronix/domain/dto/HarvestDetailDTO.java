package me.elhakimi.citronix.domain.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import me.elhakimi.citronix.domain.Harvest;
import me.elhakimi.citronix.domain.Tree;


@Getter
@Setter
public class HarvestDetailDTO {

    private Long id;

    @PositiveOrZero
    private double quantity;

    private Harvest harvest;

    private Tree tree;

}
