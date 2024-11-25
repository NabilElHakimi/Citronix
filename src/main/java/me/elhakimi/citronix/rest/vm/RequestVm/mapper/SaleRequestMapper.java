package me.elhakimi.citronix.rest.vm.RequestVm.mapper;

import me.elhakimi.citronix.domain.Sale;
import me.elhakimi.citronix.rest.vm.RequestVm.SaleRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SaleRequestMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "saleDate", target = "saleDate")
    @Mapping(source = "unitPrice", target = "unitPrice")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "client", target = "client")
    Sale toSale(SaleRequest saleRequest);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "saleDate", target = "saleDate")
    @Mapping(source = "unitPrice", target = "unitPrice")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "client", target = "client")
    SaleRequest toSaleVm(Sale sale);

}
