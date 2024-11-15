package me.elhakimi.citronix.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDate saleDate;

    @Positive
    private double unitPrice;

    @Positive
    private double quantity;

    private String client;

    @ManyToOne
    @JoinColumn(name = "harvest_id")
    private Harvest harvest;

    public double getRevenue() {
        return quantity * unitPrice;
    }
}
