package com.example.kakkaibackend.controllers;



import com.example.kakkaibackend.entities.Region;
import com.example.kakkaibackend.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/region")
public class RegionController {
    @Autowired
    private RegionService regionService;

    @GetMapping("")
    public List<Region> getAllRegion(){
        return regionService.getAllRegion();
    }

    @GetMapping("/{id}")
    public Region getRegionById(@PathVariable Integer id){
        return regionService.getRegionById(id);
    }

    @GetMapping("/name")
    public String name(){
        return "Geist" ;
    }

}
