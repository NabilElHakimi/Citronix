package me.elhakimi.citronix.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.Period;

@Entity
public class Tree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDate plantingDate;

    @Transient
    private int age;

    @ManyToOne
    @JoinColumn(name = "field_id")
    private Field field;

    @PostLoad
    public void calculateAge() {
        this.age = Period.between(this.plantingDate, LocalDate.now()).getYears();
    }

    public double getProductivity() {
        if (age < 3) return 2.5;
        if (age <= 10) return 12.0;
        if (age <= 20) return 20.0;
        return 0.0;
    }
}

