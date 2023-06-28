package com.example.kakkaibackend.entities;


import com.example.kakkaibackend.utils.RoomStatusEnum;
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
@Table(name="room")
public class Room {
    @Id
    @Column(name = "roomID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "roomNumber",nullable = false)
    private String roomNumber;

    @Column(name = "floor",nullable = false)
    private String floor;

    @Column(name = "roomType",nullable = false)
    private String roomType;

    @Enumerated(EnumType.STRING)
    @Column(name = "roomStatus")
    private RoomStatusEnum roomStatus;

    @Column(name = "roomCapacity",nullable = false)
    private String roomCapacity;

    @Column(name = "roomRate",nullable = false)
    private String roomRate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "hotelID")
    private Hotel hotel;

}
