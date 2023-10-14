package com.example.kakkaibackend.controllers;

import com.example.kakkaibackend.entities.Region;
import com.example.kakkaibackend.entities.Tub;
import com.example.kakkaibackend.repositories.RegionRepository;
import com.example.kakkaibackend.repositories.TubRepository;
import com.example.kakkaibackend.services.RegionService;
import com.example.kakkaibackend.services.TubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "http://localhost:5173")

@RestController
@RequestMapping("/api/tubs")
public class TubController {

    @Autowired
    private TubService tubService;
    @Autowired
    private TubRepository tubRepository;

    @GetMapping("")
    public List<Tub> getAllTub(){
        return tubService.getAllTub();
    }

    @GetMapping("/{id}")
    public Tub getTubById(@PathVariable Integer id){
        return tubService.getTubById(id);
    }


    @GetMapping("/images/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Integer id) {
        Tub tub = tubRepository.findById(id).orElse(null);
        if (tub != null) {
            File file = new File(tub.getTubPicture());
            try {
                byte[] imageData = Files.readAllBytes(file.toPath());
                return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ResponseEntity.notFound().build();
    }
}
