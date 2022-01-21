package com.example.TripEvaluator;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Trip emptyTrip(){
        return new Trip(null,"Wypoczynek","Turcja",5000,null);
    }
    public void addReview(Trip trip, Review review){
        if(trip.getReviews() != null){
            trip.getReviews().add(review);
        }
    }

    public List<Trip> getAll() {
        update();
        List<Trip> allById = tripRepository.findAllByIdGreaterThan(5);
        return allById;
    }

    private void update() {
        tripRepository.updateTrip("wycieczka do zoo",1);
    }

    public Trip findById(Integer id) {
        Trip trip = null;
        Optional<Trip> byId = tripRepository.findById(id);
        return byId.orElse(null);
    }

    public void deleteById(Integer id) {
        tripRepository.deleteById(id);
    }

}
