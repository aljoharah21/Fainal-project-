package com.example.demo.Type;


import com.example.demo.Plants.Plants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {
    private final TypeRepository typeRepository;
@Autowired
    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public List<Type> getType() {return typeRepository.findAll();}


    public Type getType(String id) {
        Long Type_id = Long.parseLong(id);
        return typeRepository.findById(Type_id).orElse(null);
    }


    public Type createType(Type type) {
        return typeRepository.save(type);
    }

    public Type getTypeByName(String name) {
        return typeRepository.findByName(name);
    }
}

