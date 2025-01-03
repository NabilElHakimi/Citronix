package me.elhakimi.citronix.rest.vm.RequestVm.mapper;

import me.elhakimi.citronix.domain.Harvest;
import me.elhakimi.citronix.rest.vm.RequestVm.HarvestRequest;
import me.elhakimi.citronix.rest.vm.ResponseVm.HarvestVm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HarvestRequestMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "harvestDate", target = "harvestDate")
    @Mapping(source = "season", target = "season")
    @Mapping(source = "totalQuantity", target = "totalQuantity")
    HarvestVm toHarvestVm(Harvest harvest);

    @Mapping(source = "id", target = "id")
    Harvest toHarvest(HarvestRequest harvestRequest);

}
