package me.elhakimi.citronix.rest.vm.ResponseVm.mapper;

import me.elhakimi.citronix.domain.Harvest;
import me.elhakimi.citronix.rest.vm.ResponseVm.HarvestVm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HarvestVmMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "harvestDate", target = "harvestDate")
    @Mapping(source = "season", target = "season")
    @Mapping(source = "totalQuantity", target = "totalQuantity")
    @Mapping(source = "details", target = "details")
    HarvestVm toHarvestVm(Harvest harvest);

    @Mapping(source = "id", target = "id")
    Harvest toHarvest(HarvestVm harvestVm);

}
