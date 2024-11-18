package me.elhakimi.citronix.Repository;

import me.elhakimi.citronix.domain.Farm;
import me.elhakimi.citronix.domain.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FieldRepository extends JpaRepository<Field, Long> {
        List<Field> searchAllByFarm(Farm farm) ;
}
