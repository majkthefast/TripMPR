package com.example.TripEvaluator;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class TripServiceIT {

    @MockBean
    private TripRepository tripRepository;

    @Autowired
    private TripService tripService;

    @Test
    void addReview(){
        Trip trip = new Trip(null,"Wypoczynek","Turcja",5000,new ArrayList<>());
        Author author = new Author(null,"Krzysztof","Szymczyk",20);
        List<Author> authors = List.of(author);
        Review review = new Review(null,"content",authors ,5,Opinion.POSITIVE);
        tripService.addReview(trip, review);
        assertThat(trip.getReviews()).isNotNull().hasSize(1);
    }
}
