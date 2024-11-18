package me.elhakimi.citronix.domain.dto.mapper;

import me.elhakimi.citronix.domain.Tree;
import me.elhakimi.citronix.domain.dto.TreeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TreeDtoMapper {

    Tree toEntity(TreeDTO treeDTO);

    TreeDTO toVm(Tree tree);
}
