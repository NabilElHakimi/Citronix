package me.elhakimi.citronix.rest.vm.RequestVm.mapper;

import me.elhakimi.citronix.domain.Tree;
import me.elhakimi.citronix.rest.vm.RequestVm.TreeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TreeRequestMapper {

    @Mapping(target = "fieldId", source = "field.id")
    TreeRequest toTreeRequest(Tree tree);

    @Mapping(source = "fieldId", target = "field.id")
    Tree toTree(TreeRequest treeRequest);

}
