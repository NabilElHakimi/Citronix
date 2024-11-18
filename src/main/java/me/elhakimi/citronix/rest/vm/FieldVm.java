package me.elhakimi.citronix.rest.vm;
import lombok.Getter;
import lombok.Setter;
import me.elhakimi.citronix.domain.Farm;

@Getter
@Setter
public class FieldVm {

        private Long id;
        private double area;
        private Farm farm;


}
