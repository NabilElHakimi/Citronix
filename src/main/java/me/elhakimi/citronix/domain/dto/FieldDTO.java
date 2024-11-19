package me.elhakimi.citronix.domain.dto;
import lombok.Getter;
import lombok.Setter;
import me.elhakimi.citronix.domain.Farm;

@Getter
@Setter
public class FieldDTO {

        private Long id;
        private double area;
        private Farm farm;


}
