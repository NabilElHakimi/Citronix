package me.elhakimi.citronix.Repository;

import me.elhakimi.citronix.domain.Harvest;
import me.elhakimi.citronix.domain.enums.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HarvestRepository extends JpaRepository<Harvest, Long> {

        @Query("SELECT h FROM Harvest h WHERE h.season = :season ORDER BY h.harvestDate DESC")
                        List<Harvest> findLastBySeason(Season season);
                }
