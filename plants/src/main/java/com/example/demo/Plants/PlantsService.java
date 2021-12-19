package com.example.demo.Plants;

import com.example.demo.Climate.Climate;
import com.example.demo.Seasons.Seasons;
import com.example.demo.Type.Type;
import com.example.demo.Climate.ClimateRepository;
import com.example.demo.Seasons.SeasonsRepository;
import com.example.demo.Type.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlantsService {

        private final PlantsRepository plantsRepository;
        private final ClimateRepository climateRepository;
        private final SeasonsRepository seasonsRepository;
        private final TypeRepository typeRepository;


        @Autowired
        public PlantsService(PlantsRepository plantsRepository, ClimateRepository climateRepository, SeasonsRepository seasonsRepository, TypeRepository typeRepository) {
        this.plantsRepository = plantsRepository;
        this.climateRepository = climateRepository;
        this.seasonsRepository = seasonsRepository;
            this.typeRepository = typeRepository;
        }


        public List<Plants> getPlants() {return plantsRepository.findAll();}


    public Plants getPlants(String id) {
        Long Plants_id = Long.parseLong(id);
        return plantsRepository.findById(Plants_id).orElse(null);
    }

//    public Plants getPlants(String name) {
//        Long Plants_neme = Long.parseLong(name);
//        return plantsRepository.findById(Plants_name).orElse(null);
//    }

    public Plants createPlants(Plants plants) {
        Climate c = climateRepository.findById(plants.getClimate().getId()).orElse(null);
        Type t = typeRepository.findById(plants.getType().getId()).orElse(null);
        Seasons s = seasonsRepository.findById(plants.getSeasons().getId()).orElse(null);
        plants.setClimate(c);
        plants.setType(t);
        plants.setSeasons(s);
        return plantsRepository.save(plants);
    }

    public Plants getPlantsByName(String name) {
            return plantsRepository.findByName(name);
    }
}
