package com.example.kakkaibackend.services;

import com.example.kakkaibackend.entities.Province;
import com.example.kakkaibackend.entities.Region;
import com.example.kakkaibackend.repositories.ProvinceRepository;
import com.example.kakkaibackend.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;

    public List< Province> getAllProvince(){
        return provinceRepository.findAll();
    }

    public Province getProvinceById(Integer id){
        return provinceRepository.findById(id).orElseThrow(()->new RuntimeException("cannot find region id="+id));
    }
}
