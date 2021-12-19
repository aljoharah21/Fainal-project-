package com.example.demo.Type;

import com.example.demo.Seasons.Seasons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "type")
public class TypeController {
    private final TypeService typeService;

    @Autowired
    public TypeController (TypeService typeService) {this.typeService =typeService;
    }

    @GetMapping
    public List<Type> getType(){
        return typeService.getType();
    }

    @GetMapping("/{id}")
    public Type getType(@PathVariable String id){return typeService.getType(id);
    }

    @GetMapping("seasonsByName/{name}")
    public Type getTypeByName (@PathVariable String name){
        return typeService.getTypeByName(name);
    }
    @PostMapping
    public Type createType(@RequestBody Type type){return typeService.createType(type);}


}
