package me.elhakimi.citronix.rest.vm.ResponseVm.mapper;

import me.elhakimi.citronix.domain.Tree;
import me.elhakimi.citronix.rest.vm.ResponseVm.TreeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TreeVmMapper {

    @Mapping(target = "fieldName", source = "field.name")
    TreeResponse toTreeVm(Tree tree);

    @Mapping(source = "fieldName", target = "field.name")
    Tree toTree(TreeResponse treeResponse);

}
