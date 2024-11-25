package me.elhakimi.citronix.rest.vm.RequestVm.mapper;

import me.elhakimi.citronix.domain.Farm;
import me.elhakimi.citronix.rest.vm.FarmVm;
import me.elhakimi.citronix.rest.vm.RequestVm.FarmRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FarmRequestMapper {

    FarmRequest toFarmVm(Farm farm);
    Farm toFarm(FarmRequest farmVm);

}
