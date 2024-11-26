package me.elhakimi.citronix.rest.vm.RequestVm.mapper;

import me.elhakimi.citronix.domain.Farm;
import me.elhakimi.citronix.rest.vm.RequestVm.FarmRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FarmRequestMapper {

    FarmRequest toFarmVm(Farm farm);
    Farm toFarm(FarmRequest farmVm);

}
