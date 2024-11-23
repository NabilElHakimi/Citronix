package me.elhakimi.citronix.service.interfaces;

import me.elhakimi.citronix.domain.Tree;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface TreeService {
    Page<Tree> findAll(int page, int size);
    Tree save(Tree tree);
    Tree update(Tree tree);
    void delete(Long id);
    Tree findById(Long id);
//    List<Tree> searchAll(String name, Double height, String location, LocalDate plantingDate, Long id);
}
