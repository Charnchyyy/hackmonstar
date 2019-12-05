package com.hackmonstar.asoke.repositories;

import com.hackmonstar.asoke.models.GPS;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface GPSRepository extends JpaRepository<GPS, String> {

    @Transactional
    @Query(value = "SELECT * FROM gps WHERE meter!=2 LIMIT 1000", nativeQuery = true)
    List<GPS> findTaxi();

    @Transactional
    @Query(value = "SELECT * FROM gps WHERE meter = ? LIMIT 1000", nativeQuery = true)
    List<GPS> findTaxiByMeter(@Param("meter") String meter);
}
