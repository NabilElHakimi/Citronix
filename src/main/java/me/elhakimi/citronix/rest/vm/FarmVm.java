package me.elhakimi.citronix.rest.vm;

import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
public class FarmVm {

        private Long id;
        private String name;
        private String location;
        private double area;
        private LocalDate creationDate;

}
