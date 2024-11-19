package me.elhakimi.citronix.domain.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
public class FarmDTO {

        private Long id;
        private String name;
        private String location;
        private double area;
        private LocalDate creationDate;

}

