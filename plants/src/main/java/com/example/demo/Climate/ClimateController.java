package com.example.demo.Climate;


import com.example.demo.Plants.Plants;
import com.example.demo.Type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path = "climate")
@CrossOrigin("*")

public class ClimateController {
    
    private final ClimateService climateService;

    @Autowired
    public ClimateController (ClimateService climateService) {
        this.climateService=climateService;
    }

    @GetMapping
    public List<Climate> getClimates(){
        return climateService.getClimates();
    }

    @GetMapping("/{id}")
    public Climate getClimate(@PathVariable String id){return climateService.getClimate(id);
    }
    @GetMapping("climateByName/{name}")
    public Climate getClimateByName (@PathVariable String name) {
        return climateService.getClimateByName(name);
    }
    @PostMapping
    public Climate createClimate(@RequestBody Climate climate){return climateService.createClimate(climate);}

}
