package me.elhakimi.citronix.Repository;

import me.elhakimi.citronix.domain.Harvest;
import me.elhakimi.citronix.domain.enums.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HarvestRepository extends JpaRepository<Harvest, Long> {

        Harvest findBySeason(Season season);

}
