package com.example.demo.Plants;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "plants")
public class PlantsController {
    private final PlantsService plantsService;

    @Autowired
    public PlantsController(PlantsService plantsService) {
        this.plantsService = plantsService;
    }

    @GetMapping
    public List<Plants> getPlants () {
        return plantsService.getPlants();
    }

    @GetMapping("/{id}")
    public Plants getPlants (@PathVariable String id){
        return plantsService.getPlants(id);
    }

   @GetMapping("plantByName/{name}")
   public Plants getPlantByName (@PathVariable String name){
        return plantsService.getPlantsByName(name);
    }

    @PostMapping
    public Plants createPlants (@RequestBody Plants plants){
        return plantsService.createPlants(plants);
    }


}
