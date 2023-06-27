package com.example.kakkaibackend.services;

import com.example.kakkaibackend.entities.Region;
import com.example.kakkaibackend.repositories.RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    public List<Region> getAllRegion(){
        return regionRepository.findAll();
    }

    public Region getRegionById(Integer id){
        return regionRepository.findById(id).orElseThrow(()->new RuntimeException("cannot find region id="+id));
    }

}


