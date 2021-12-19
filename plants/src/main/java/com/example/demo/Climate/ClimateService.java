package com.example.demo.Climate;

import com.example.demo.Type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.demo.Plants.Plants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClimateService {

    private final ClimateRepository climateRepository;

    @Autowired
    public ClimateService(ClimateRepository climateRepository) {
        this.climateRepository = climateRepository;
    }



    public List<Climate> getClimates() {return climateRepository.findAll();}

    public Climate getClimate(String id) {
        Long climate_id = Long.parseLong(id);
        return climateRepository.findById(climate_id).orElse(null);
    }

    public Climate createClimate(Climate climate) {return climateRepository.save(climate);
    }

    public Climate getClimateByName(String name) {
        return climateRepository.findByName(name);
    }


}
