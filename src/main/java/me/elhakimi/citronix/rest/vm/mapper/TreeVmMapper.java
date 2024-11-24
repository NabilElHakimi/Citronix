package me.elhakimi.citronix.rest.vm.mapper;

import me.elhakimi.citronix.domain.Tree;
import me.elhakimi.citronix.rest.vm.FieldVm;
import me.elhakimi.citronix.rest.vm.TreeVm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TreeVmMapper {

//    TreeVmMapper INSTANCE = Mappers.getMapper(TreeVmMapper.class);

    @Mapping(target = "fieldId", source = "field.id")
//    @Mapping(target = "field.name", source = "field.name")
//    @Mapping(target = "field.area", source = "field.area")
//    @Mapping(target = "field.trees", ignore = true)
    TreeVm toTreeVm(Tree tree);

//    @Mapping(target = "field", ignore = true)
    @Mapping(source = "fieldId", target = "field.id")
    Tree toTree(TreeVm treeVm);
}
