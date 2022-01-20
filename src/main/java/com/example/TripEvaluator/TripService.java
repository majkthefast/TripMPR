package com.example.TripEvaluator;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    private final TripRepository tripRepository;

    public TripService(TripRepository tripRepository){
        this.tripRepository = tripRepository;
    }

    public Trip createTrip(){
        Author author = new Author(null,"Krzysztof","Szymczyk",20);
        List<Author> authors = List.of(author);
        Review review = new Review(null,"content",authors ,5,Opinion.POSITIVE);
        List<Review> reviews = List.of(review);
        Trip trip = new Trip(null,"Wakacje","Bałyk",1000,reviews);
        return tripRepository.save(trip);
    }
}
