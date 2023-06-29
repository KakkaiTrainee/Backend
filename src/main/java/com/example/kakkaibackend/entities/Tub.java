package com.example.kakkaibackend.entities;

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
@Table(name="tub")
public class Tub {
    @Id
    @Column(name = "tubID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tubName",nullable = false)
    private String tubName;

    @Column(name = "tubAmountPeople",nullable = false)
    private String tubAmountPeople;

    @Column(name = "regionPicture",nullable = false)
    private String regionPicture;
}
