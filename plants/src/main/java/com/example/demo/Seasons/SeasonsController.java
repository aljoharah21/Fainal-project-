package com.example.demo.Seasons;


import com.example.demo.Plants.Plants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "seasons")

public class SeasonsController {
    private final  SeasonsService seasonsService;

    @Autowired
    public SeasonsController (SeasonsService seasonsService) {this.seasonsService =seasonsService;
    }

    @GetMapping
    public List<Seasons> getSeasons(){
        return seasonsService.getSeasons();
    }

    @GetMapping("/{id}")
    public Seasons getSeasons(@PathVariable String id){return seasonsService.getSeasons(id);
    }
    @GetMapping("seasonsByName/{name}")
    public Seasons getSeasonsByName (@PathVariable String name){
        return seasonsService.getSeasonsByName(name);
    }
    @PostMapping
    public Seasons createSeasons(@RequestBody Seasons seasons){return seasonsService.createSeasons(seasons);}

}


