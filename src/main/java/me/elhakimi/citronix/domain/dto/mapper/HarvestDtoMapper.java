package me.elhakimi.citronix.domain.dto.mapper;

import me.elhakimi.citronix.domain.Farm;
import me.elhakimi.citronix.domain.Harvest;
import me.elhakimi.citronix.domain.dto.FarmDTO;
import me.elhakimi.citronix.domain.dto.HarvestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HarvestDtoMapper {

    @Mapping(source = "id", target = "id")
    HarvestDTO toHarvestVm(Harvest harvest);

    @Mapping(source = "id", target = "id")
    Harvest toFarm(HarvestDTO harvestDTO);
}
