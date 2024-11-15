package me.elhakimi.citronix.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class HarvestDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @PositiveOrZero
    private double quantity;

    @ManyToOne
    @JoinColumn(name = "harvest_id")
    private Harvest harvest;

    @ManyToOne
    @JoinColumn(name = "tree_id")
    private Tree tree;
}
