package me.elhakimi.citronix.rest.vm.mapper;

import me.elhakimi.citronix.domain.Farm;
import me.elhakimi.citronix.rest.vm.FarmVm;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FarmMapper {

    FarmVm toFarmVm(Farm farm);

    Farm toFarm(FarmVm farmVm);

}
