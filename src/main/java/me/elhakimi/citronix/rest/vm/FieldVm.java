package me.elhakimi.citronix.rest.vm;

import lombok.Getter;
import lombok.Setter;
import me.elhakimi.citronix.domain.Farm;
import me.elhakimi.citronix.domain.Tree;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter

public class FieldVm {
    private Long id;
    private String name;
    private double area;
    private List<Tree> trees = new ArrayList<>();

}
