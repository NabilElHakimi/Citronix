package me.elhakimi.citronix.rest.vm;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import me.elhakimi.citronix.domain.Field;

import java.time.LocalDate;

@Getter
@Setter
public class TreeVm {

    @NotNull
    private LocalDate plantingDate ;

    @NotNull
    private Long filedId;

}
