package me.elhakimi.citronix.rest.vm.mapper;

import me.elhakimi.citronix.domain.Harvest;
import me.elhakimi.citronix.rest.vm.HarvestDetailVm;
import me.elhakimi.citronix.rest.vm.HarvestVm;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HarvestDetailVmMapper {

    HarvestDetailVm toHarvestDetail(Harvest harvestDetail);
    Harvest toHarvestDetail(HarvestDetailVm harvestDetailVm);

}
