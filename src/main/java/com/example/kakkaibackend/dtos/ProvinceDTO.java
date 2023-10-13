package com.example.kakkaibackend.dtos;

import com.example.kakkaibackend.entities.Region;
import com.example.kakkaibackend.utils.provinceTravelEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

public class ProvinceDTO {
    @Id
    private Integer id;
    private String provinceName;
    private String provincePicture;
//    private provinceTravelEnum provinceTravel;

    @JsonIgnore
    private Region provinceRegion;
    public String getProvinceRegion(){
        return provinceRegion.getRegionName();
    }
}
