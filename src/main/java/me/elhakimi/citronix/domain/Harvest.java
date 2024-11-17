package me.elhakimi.citronix.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import me.elhakimi.citronix.domain.enums.Season;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
    public class Harvest {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotNull
        private LocalDate harvestDate;

        @Enumerated(EnumType.STRING)
        private Season season;

        @PositiveOrZero
        private double totalQuantity;

        @OneToMany(mappedBy = "harvest", cascade = CascadeType.ALL)
        private List<HarvestDetail> details = new ArrayList<>();
    }
