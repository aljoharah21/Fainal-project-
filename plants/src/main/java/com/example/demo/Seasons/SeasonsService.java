package com.example.demo.Seasons;

import com.example.demo.Plants.Plants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeasonsService {

    private final SeasonsRepository seasonsRepository;

    @Autowired
    public SeasonsService(SeasonsRepository seasonsRepository) {
        this.seasonsRepository = seasonsRepository;
    }

    public List<Seasons> getSeasons() {return seasonsRepository.findAll();
    }

    public Seasons getSeasons(String id) {
        Long seasons_id = Long.parseLong(id);
        return seasonsRepository.findById(seasons_id).orElse(null);
    }

    public Seasons createSeasons(Seasons seasons) {return seasonsRepository.save(seasons);
    }
    public Seasons getSeasonsByName(String name) {
        return seasonsRepository.findByName(name);
    }
}


