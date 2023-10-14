package com.example.kakkaibackend.controllers;



import com.example.kakkaibackend.entities.Region;
import com.example.kakkaibackend.repositories.RegionRepository;
import com.example.kakkaibackend.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "http://localhost:5173")

@RestController
@RequestMapping("/api/regions")
public class RegionController {
    @Autowired
    private RegionService regionService;
    @Autowired
    private RegionRepository regionRepository;

    @GetMapping("")
    public List<Region> getAllRegion(){
        return regionService.getAllRegion();
    }

    @GetMapping("/{id}")
    public Region getRegionById(@PathVariable Integer id){
        return regionService.getRegionById(id);
    }


    @GetMapping("/images/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Integer id) {
        Region region = regionRepository.findById(id).orElse(null);
        if (region != null) {
            File file = new File(region.getRegionPicture());
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




