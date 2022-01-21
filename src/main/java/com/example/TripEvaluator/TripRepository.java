package com.example.TripEvaluator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE Trip t SET t.title = :title where t.id = :id")
    void updateTrip(String title, Integer id);

    List<Trip> findAllByIdGreaterThan(Integer id);

}
