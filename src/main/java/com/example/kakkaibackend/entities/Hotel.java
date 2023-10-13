package com.example.kakkaibackend.entities;


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
@Table(name="hotel")
public class Hotel {
    @Id
    @Column(name = "hotelID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "hotelName",nullable = false)
    private String hotelName;

    @Column(name = "hotelPicture",nullable = false)
    private String hotelPicture;

    @Column(name = "hotelLocation",nullable = false)
    private String hotelLocation;

    @Column(name = "hotelReview",nullable = false)
    private String hotelReview;

    @Column(name = "hotelFacilities",nullable = false)
    private String hotelFacilities;

    @Column(name = "hotelAmountPeople",nullable = false)
    private String hotelAmountPeople;

    @Column(name = "hotelPhone",nullable = false)
    private String hotelPhone;

    @Column(name = "hotelLink",nullable = false)
    private String hotelLink;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "hotelProvince")
    private Province hotelProvince;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "hotelTub")
    private Tub hotelTub;

}   
