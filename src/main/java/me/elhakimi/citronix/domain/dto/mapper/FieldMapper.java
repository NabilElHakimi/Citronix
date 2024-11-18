package me.elhakimi.citronix.domain.dto.mapper;

import me.elhakimi.citronix.domain.Field;
import me.elhakimi.citronix.domain.dto.FieldDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FieldMapper {

    @Mapping(source = "id", target = "id")
    FieldDTO toFarmVm(Field field);

    @Mapping(source = "id", target = "id")
    Field toFarm(FieldDTO fieldDTO);
}
