package me.elhakimi.citronix.rest.vm.mapper;

import me.elhakimi.citronix.domain.Farm;
import me.elhakimi.citronix.rest.vm.FarmVm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FarmMapper {

    @Mapping(source = "id", target = "id")
    FarmVm toFarmVm(Farm farm);

    @Mapping(source = "id", target = "id")
    Farm toFarm(FarmVm farmVm);

}
