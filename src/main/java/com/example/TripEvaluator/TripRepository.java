package com.example.TripEvaluator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface TripRepository extends JpaRepository<Trip, Integer> {

//    @Transactional
//    @Modifying
//    @Query("UPDATE Trip t SET t.title = :title, t.cena = : cena where t.id = :id")
//    int updateTrip(String title, int cena, Integer id);

}
