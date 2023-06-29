package com.example.kakkaibackend.services;

import com.example.kakkaibackend.dtos.ProvinceDTO;
import com.example.kakkaibackend.entities.Province;
import com.example.kakkaibackend.entities.Region;
import com.example.kakkaibackend.repositories.ProvinceRepository;
import com.example.kakkaibackend.repositories.RegionRepository;
import com.example.kakkaibackend.utils.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ListMapper listMapper;

    public List< Province> getAllProvince(){
        return provinceRepository.findAll();
    }

    public Province getProvinceById(Integer id){
        return provinceRepository.findById(id).orElseThrow(()->new RuntimeException("cannot find region id="+id));
    }

//    public List<ProvinceDTO> getProvinceDTO() {
//        List<Province> todos = getAllProvince();
//        return todos.stream().map(t -> modelMapper.map(t, ProvinceDTO.class)).collect(Collectors.toList());
//    }
//
//    public ProvinceDTO getProvinceDtoById(Integer id) {
//        return modelMapper.map(getProvinceDtoById(id), ProvinceDTO.class);
//    }


}
