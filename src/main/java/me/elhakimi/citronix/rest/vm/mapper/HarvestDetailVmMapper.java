package me.elhakimi.citronix.rest.vm.mapper;

import me.elhakimi.citronix.domain.Harvest;
import me.elhakimi.citronix.domain.HarvestDetail;
import me.elhakimi.citronix.rest.vm.HarvestDetailVm;
import me.elhakimi.citronix.rest.vm.HarvestVm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HarvestDetailVmMapper {


    @Mapping(source = "id", target = "id")
    @Mapping(source = "harvestId", target = "harvest.id")
    @Mapping(source = "treeId", target = "tree.id")
    HarvestDetail toHarvestDetail(HarvestDetailVm harvestDetailVm);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "harvest.id", target = "harvestId")
    @Mapping(source = "tree.id", target = "treeId")
    HarvestDetailVm toHarvestDetailVm(HarvestDetail harvestDetail);

}