package com.example.kakkaibackend.controllers;

import com.example.kakkaibackend.entities.Province;
import com.example.kakkaibackend.entities.Region;
import com.example.kakkaibackend.services.ProvinceService;
import com.example.kakkaibackend.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/provinces")
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;

    @GetMapping("")
    public List<Province> getAllProvince(){
        return provinceService.getAllProvince();
    }

    @GetMapping("/{id}")
    public Province getProvinceById(@PathVariable Integer id){
        return provinceService.getProvinceById(id);
    }


}
