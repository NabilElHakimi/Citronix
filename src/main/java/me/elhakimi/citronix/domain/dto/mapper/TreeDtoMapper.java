package me.elhakimi.citronix.domain.dto.mapper;

import me.elhakimi.citronix.domain.Tree;
import me.elhakimi.citronix.domain.dto.TreeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TreeDtoMapper {

    @Mapping(source = "id", target = "id")
    Tree toEntity(TreeDTO treeDTO);

    @Mapping(source = "id", target = "id")
    TreeDTO toVm(Tree tree);
}
