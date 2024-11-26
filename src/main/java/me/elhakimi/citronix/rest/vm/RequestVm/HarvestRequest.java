package me.elhakimi.citronix.rest.vm.RequestVm;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import me.elhakimi.citronix.domain.HarvestDetail;
import me.elhakimi.citronix.domain.enums.Season;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class HarvestRequest {
    private Long id;

    private LocalDate harvestDate;

    @Enumerated(EnumType.STRING)
    private Season season;

    @PositiveOrZero
    private double totalQuantity;

}
