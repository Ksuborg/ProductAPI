package md.test.repository;

import md.test.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, String> {
    @Query("select manufacturer_name from Manufacturer " +
            "where manufacturer_id in " +
            "(select manufacturer_id from Product group by manufacturer_id having count(manufacturer_id) > ${num}")
    List<String> findManufacturersByNum(int num);
}