package me.elhakimi.citronix.rest.vm.mapper;

import me.elhakimi.citronix.domain.Farm;
import me.elhakimi.citronix.domain.Field;
import me.elhakimi.citronix.rest.vm.FarmVm;
import me.elhakimi.citronix.rest.vm.FieldVm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")

public interface FieldVmMapper {


    @Mapping(target = "id" , source = "id")
    Field toField(FieldVm fieldVm);

    @Mapping(target = "id" , source = "id")
    FieldVm toFieldVm(Field field);

}
