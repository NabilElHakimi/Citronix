package me.elhakimi.citronix.domain.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import me.elhakimi.citronix.domain.HarvestDetail;
import me.elhakimi.citronix.domain.enums.Season;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class HarvestDTO {

        private Long id;

        @NotNull
        private LocalDate harvestDate;

        @Enumerated(EnumType.STRING)
        private Season season;

        @PositiveOrZero
        private double totalQuantity;

        private List<HarvestDetail> details = new ArrayList<>();

    }
