package me.elhakimi.citronix.Repository;

import me.elhakimi.citronix.domain.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {

    @Query("SELECT f FROM Farm f " +
            "WHERE (:name IS NULL OR f.name LIKE %:name%) " +
            "AND (:area IS NULL OR f.area = :area) " +
            "AND (:creationDate IS NULL OR f.creationDate = :creationDate) " +
            "AND (:id IS NULL OR f.id = :id) " +
            "AND (:location IS NULL OR f.location LIKE %:location%)")
    List<Farm> searchAllByNameOrAreaOrCreationDateOrIdOrLocation(
            @Param("name") String name,
            @Param("area") Double area,
            @Param("creationDate") LocalDate creationDate,
            @Param("id") Long id,
            @Param("location") String location
    );


}
