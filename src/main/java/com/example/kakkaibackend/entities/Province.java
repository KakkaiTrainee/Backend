package com.example.kakkaibackend.entities;


import com.example.kakkaibackend.utils.provinceTravelEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="province")
public class Province {
    @Id
    @Column(name = "provinceID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "provinceName",nullable = false)
    private String provinceName;

    @Column(name = "provincePicture",nullable = false)
    private String provincePicture;

    @Enumerated(EnumType.STRING)
    @Column(name = "provinceTravel",nullable = false)
    private provinceTravelEnum provinceTravel;


    @ManyToOne
    @JoinColumn(name = "provinceRegion")
    private Region provinceRegion;
}
