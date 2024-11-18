package me.elhakimi.citronix.domain.dto;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TreeDTO {

    @NotNull
    private LocalDate plantingDate ;

    @NotNull
    private Long filedId;

}
