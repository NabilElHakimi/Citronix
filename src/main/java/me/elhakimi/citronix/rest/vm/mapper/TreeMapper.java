package me.elhakimi.citronix.rest.vm.mapper;

import me.elhakimi.citronix.domain.Tree;
import me.elhakimi.citronix.rest.vm.TreeVm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TreeMapper {

    @Mapping(target = "field.id", source = "filedId")
    Tree toEntity(TreeVm treeVm);

    @Mapping(target = "filedId", source = "field.id")
    TreeVm toVm(Tree tree);
}
