package me.elhakimi.citronix.rest.vm.mapper;

import me.elhakimi.citronix.domain.Farm;
import me.elhakimi.citronix.domain.Tree;
import me.elhakimi.citronix.rest.vm.FarmVm;
import me.elhakimi.citronix.rest.vm.TreeVm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FarmVmMapper {

    FarmVm toFarmVm(Farm farm);
    Farm toFarm(FarmVm farmVm);
    List<Farm> toFarmList(List<FarmVm> farmVmList);
    List<FarmVm> toFarmVmList(List<Farm> farmList);

}
