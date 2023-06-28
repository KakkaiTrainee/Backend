package com.example.kakkaibackend.controllers;



import com.example.kakkaibackend.entities.Region;
import com.example.kakkaibackend.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

@RestController
@RequestMapping("/api/regions")
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

    @GetMapping(value = "/{id}/picture", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getRegionPicture(@PathVariable Integer id) {
        byte[] pictureData = regionService.getRegionPicture(id);
        if (pictureData != null) {
            return ResponseEntity.ok(pictureData);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}




