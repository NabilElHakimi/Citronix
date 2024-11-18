package me.elhakimi.citronix.domain.dto.mapper;

import me.elhakimi.citronix.domain.Tree;
import me.elhakimi.citronix.domain.dto.TreeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TreeMapper {

    @Mapping(target = "field.id", source = "filedId")
    Tree toEntity(TreeDTO treeDTO);

    @Mapping(target = "filedId", source = "field.id")
    TreeDTO toVm(Tree tree);
}
