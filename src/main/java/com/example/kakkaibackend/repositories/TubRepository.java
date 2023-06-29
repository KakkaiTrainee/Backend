package com.example.kakkaibackend.repositories;


import com.example.kakkaibackend.entities.Tub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TubRepository extends JpaRepository<Tub,Integer> {

}
