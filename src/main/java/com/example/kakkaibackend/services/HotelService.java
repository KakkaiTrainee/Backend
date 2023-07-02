package com.example.kakkaibackend.services;

import com.example.kakkaibackend.entities.Hotel;
import com.example.kakkaibackend.entities.Province;
import com.example.kakkaibackend.repositories.HotelRepository;
import com.example.kakkaibackend.repositories.ProvinceRepository;
import com.example.kakkaibackend.utils.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ListMapper listMapper;

    public List<Hotel> getAllHotel(){
        return hotelRepository.findAll();
    }

    public Hotel getHotelById(Integer id){
        return hotelRepository.findById(id).orElseThrow(()->new RuntimeException("cannot find region id="+id));
    }

}
