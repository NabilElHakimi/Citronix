package me.elhakimi.citronix.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDate plantingDate;

    @ManyToOne
    @JoinColumn(name = "field_id")
    private Field field;


    public int getAge() {
        return plantingDate != null ? Period.between(plantingDate, LocalDate.now()).getYears() : 0;
    }


    public double getProductivity() {
        int age = getAge();
        if (age < 3) return 2.5;
        if (age <= 10) return 12.0;
        if (age <= 20) return 20.0;
        return 0.0;
    }


}
