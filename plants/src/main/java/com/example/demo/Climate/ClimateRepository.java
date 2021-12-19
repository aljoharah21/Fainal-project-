package com.example.demo.Climate;

import com.example.demo.Plants.Plants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClimateRepository extends JpaRepository<Climate,Long> {

    Climate findByName(String name);

}
