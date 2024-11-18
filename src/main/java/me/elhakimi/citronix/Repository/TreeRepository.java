package me.elhakimi.citronix.Repository;

import me.elhakimi.citronix.domain.Tree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreeRepository extends JpaRepository<Tree, Long> {
//    public List<Tree> findByField(Tree tree.field);

}
