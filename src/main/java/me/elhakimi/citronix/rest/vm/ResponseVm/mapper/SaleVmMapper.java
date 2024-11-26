package me.elhakimi.citronix.rest.vm.ResponseVm.mapper;

import me.elhakimi.citronix.domain.Sale;
import me.elhakimi.citronix.rest.vm.ResponseVm.SaleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SaleVmMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "saleDate", target = "saleDate")
    @Mapping(source = "unitPrice", target = "unitPrice")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "client", target = "client")
    @Mapping(target = "harvest.id", source = "harvestId")
    Sale toSale(SaleResponse saleResponse);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "saleDate", target = "saleDate")
    @Mapping(source = "unitPrice", target = "unitPrice")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "client", target = "client")
    @Mapping(source = "harvest.id", target = "harvestId")
    SaleResponse toSaleVm(Sale sale);

}
