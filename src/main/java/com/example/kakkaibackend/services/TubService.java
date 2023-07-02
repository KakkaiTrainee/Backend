package com.example.kakkaibackend.services;

import com.example.kakkaibackend.entities.Region;
import com.example.kakkaibackend.entities.Tub;
import com.example.kakkaibackend.repositories.RegionRepository;
import com.example.kakkaibackend.repositories.TubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TubService {
    @Autowired
    private TubRepository tubRepository;


    public List<Tub> getAllTub(){
        return tubRepository.findAll();
    }

    public Tub getTubById(Integer id){
        return tubRepository.findById(id).orElseThrow(()->new RuntimeException("cannot find region id="+id));
    }

}
