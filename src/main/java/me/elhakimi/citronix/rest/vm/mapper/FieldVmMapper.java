package me.elhakimi.citronix.rest.vm.mapper;

import me.elhakimi.citronix.domain.Farm;
import me.elhakimi.citronix.domain.Field;
import me.elhakimi.citronix.rest.vm.FarmVm;
import me.elhakimi.citronix.rest.vm.FieldVm;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FieldVmMapper {

    Field toFieldVm(FieldVm fieldVm);
    FieldVm toField(Field field);

}
