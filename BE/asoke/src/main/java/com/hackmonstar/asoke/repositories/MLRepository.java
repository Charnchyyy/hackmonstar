package com.hackmonstar.asoke.repositories;

import com.hackmonstar.asoke.models.GPS;
import com.hackmonstar.asoke.models.ML;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MLRepository extends JpaRepository<ML,Float>{
    @Query(value = "SELECT * FROM ml WHERE ts = ?", nativeQuery = true)
    List<ML> findByTs(@Param("ts") String ts);
}
