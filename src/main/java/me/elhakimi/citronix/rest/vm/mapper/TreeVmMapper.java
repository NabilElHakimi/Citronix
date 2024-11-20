package me.elhakimi.citronix.rest.vm.mapper;

import me.elhakimi.citronix.domain.Tree;
import me.elhakimi.citronix.rest.vm.FieldVm;
import me.elhakimi.citronix.rest.vm.TreeVm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TreeVmMapper {

    @Mapping(target = "field", source = "field.id")
    TreeVm toTreeVm(Tree tree);

    @Mapping(target = "field", ignore = true)
    Tree toTree(TreeVm treeVm);
    FieldVm map(Long id);
}
