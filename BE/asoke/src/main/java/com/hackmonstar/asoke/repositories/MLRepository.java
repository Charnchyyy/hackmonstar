package com.hackmonstar.asoke.repositories;

import com.hackmonstar.asoke.models.ML;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MLRepository extends JpaRepository<ML,Float>{
    
}
