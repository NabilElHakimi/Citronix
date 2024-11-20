package me.elhakimi.citronix.rest.vm.mapper;

import me.elhakimi.citronix.domain.Harvest;
import me.elhakimi.citronix.domain.Harvest;
import me.elhakimi.citronix.domain.dto.HarvestDTO;
import me.elhakimi.citronix.rest.vm.FarmVm;
import me.elhakimi.citronix.rest.vm.HarvestVm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HarvestVmMapper {

    @Mapping(source = "id", target = "id")
    HarvestVm toHarvestVm(HarvestDTO harvestdto);

    @Mapping(source = "id", target = "id")
    HarvestDTO toHarvestDto(HarvestVm harvestVm);


}
