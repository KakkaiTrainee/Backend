package com.example.kakkaibackend.controllers;

import com.example.kakkaibackend.dtos.ProvinceDTO;
import com.example.kakkaibackend.entities.Province;
import com.example.kakkaibackend.entities.Region;
import com.example.kakkaibackend.repositories.ProvinceRepository;
import com.example.kakkaibackend.repositories.RegionRepository;
import com.example.kakkaibackend.services.ProvinceService;
import com.example.kakkaibackend.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@RestController
@RequestMapping("/api/provinces")
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private ProvinceRepository provinceRepository;
    @GetMapping("")
    public List<Province> getAllProvince(){
        return provinceService.getAllProvince();
    }

    @GetMapping("/{id}")
    public Province getProvinceById(@PathVariable Integer id){
        return provinceService.getProvinceById(id);
    }

//    @GetMapping("/dto/{id}")
//    public ProvinceDTO getProvincePageDto(@PathVariable Integer id){
//        return provinceService.getProvinceDtoById(id);
//    }
//
//    @GetMapping("/dto")
//    public List<ProvinceDTO> getProvincePageDto(){
//        return  provinceService.getProvinceDTO();
//    }
//



    @GetMapping("/images/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Integer id) {
        Province province = provinceRepository.findById(id).orElse(null);
        if (province != null) {
            File file = new File(province.getProvincePicture());
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
