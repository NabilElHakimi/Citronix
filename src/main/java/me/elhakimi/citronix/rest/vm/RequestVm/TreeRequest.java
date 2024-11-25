package me.elhakimi.citronix.rest.vm.RequestVm;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class TreeRequest {

    private Long id;
    private LocalDate plantingDate;
    private Long fieldId;

}
