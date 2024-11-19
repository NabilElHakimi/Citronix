package me.elhakimi.citronix.domain.dto.mapper;

import me.elhakimi.citronix.domain.Harvest;
import me.elhakimi.citronix.domain.HarvestDetail;
import me.elhakimi.citronix.domain.dto.HarvestDTO;
import me.elhakimi.citronix.domain.dto.HarvestDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HarvestDetailDtoMapper {

    @Mapping(source = "id", target = "id")
    HarvestDetailDTO toHarvestVm(HarvestDetail harvestDetail);

    @Mapping(source = "id", target = "id")
    HarvestDetail toHarvest(HarvestDetailDTO harvestDetailDTO);
}
