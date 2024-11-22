package me.elhakimi.citronix.rest.vm;

import jakarta.persistence.*;
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
public class HarvestVm {
    private Long id;

    private LocalDate harvestDate;

    @Enumerated(EnumType.STRING)
    private Season season;

    @PositiveOrZero
    private double totalQuantity;

    private List<HarvestDetail> details = new ArrayList<>();



}
