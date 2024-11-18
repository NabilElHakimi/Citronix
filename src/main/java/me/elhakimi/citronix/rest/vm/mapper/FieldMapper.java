package me.elhakimi.citronix.rest.vm.mapper;

import me.elhakimi.citronix.domain.Field;
import me.elhakimi.citronix.rest.vm.FieldVm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FieldMapper {

    @Mapping(source = "id", target = "id")
    FieldVm toFarmVm(Field field);

    @Mapping(source = "id", target = "id")
    Field toFarm(FieldVm fieldVm);
}
