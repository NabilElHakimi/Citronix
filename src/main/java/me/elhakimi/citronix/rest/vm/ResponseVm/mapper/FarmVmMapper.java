package me.elhakimi.citronix.rest.vm.ResponseVm.mapper;

import me.elhakimi.citronix.domain.Farm;
import me.elhakimi.citronix.rest.vm.ResponseVm.FarmVm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FarmVmMapper {

    @Mapping(target = "fields.farmId", ignore = true)
    FarmVm toFarmVm(Farm farm);

    Farm toFarm(FarmVm farmVm);
    List<Farm> toFarmList(List<FarmVm> farmVmList);
    List<FarmVm> toFarmVmList(List<Farm> farmList);


}
