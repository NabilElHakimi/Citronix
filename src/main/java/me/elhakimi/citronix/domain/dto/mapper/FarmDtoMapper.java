package me.elhakimi.citronix.domain.dto.mapper;

import me.elhakimi.citronix.domain.Farm;
import me.elhakimi.citronix.domain.dto.FarmDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FarmDtoMapper {

    @Mapping(source = "id", target = "id")
    FarmDTO toFarmVm(Farm farm);

    @Mapping(source = "id", target = "id")
    Farm toFarm(FarmDTO farmDTO);
}
