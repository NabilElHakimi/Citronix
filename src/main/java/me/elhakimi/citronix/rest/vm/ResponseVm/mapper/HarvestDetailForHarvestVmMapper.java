package me.elhakimi.citronix.rest.vm.ResponseVm.mapper;

import me.elhakimi.citronix.domain.HarvestDetail;
import me.elhakimi.citronix.rest.vm.ResponseVm.HarvestDetailForHarvestVm;
import me.elhakimi.citronix.rest.vm.ResponseVm.HarvestDetailVm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HarvestDetailForHarvestVmMapper {


    @Mapping(source = "id", target = "id")

    HarvestDetail toHarvestDetail(HarvestDetailForHarvestVm harvestDetailVm);

    @Mapping(source = "id", target = "id")
    HarvestDetailForHarvestVm toHarvestDetailVm(HarvestDetail harvestDetail);
    
}
