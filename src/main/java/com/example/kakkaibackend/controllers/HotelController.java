package com.example.kakkaibackend.controllers;


import com.example.kakkaibackend.entities.Hotel;
import com.example.kakkaibackend.entities.Province;
import com.example.kakkaibackend.repositories.HotelRepository;
import com.example.kakkaibackend.repositories.ProvinceRepository;
import com.example.kakkaibackend.services.HotelService;
import com.example.kakkaibackend.services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "http://localhost:5173")

@RestController
@RequestMapping("/api/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;
    @Autowired
    private HotelRepository hotelRepository;
    @GetMapping("")
    public List<Hotel> getAllHotel(){
        return hotelService.getAllHotel();
    }

    @GetMapping("/{id}")
    public Hotel getHotelById(@PathVariable Integer id){

        return hotelService.getHotelById(id);
    }

    @GetMapping("/images/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Integer id) {
        Hotel hotel = hotelRepository.findById(id).orElse(null);
        if (hotel != null) {
            File file = new File(hotel.getHotelPicture());
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
