package com.example.TripEvaluator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripRestController {

    private final TripService tripService;

    public TripRestController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("/example")
    public ResponseEntity<Trip> createTrip(){
        return ResponseEntity.ok(tripService.createTrip());
    }

    @GetMapping("/empty")
    public ResponseEntity<Trip> emptyTrip(){
        return ResponseEntity.ok(tripService.emptyTrip());
    }
    @GetMapping("/all")
    public ResponseEntity<List<Trip>> getAllTrips(){
        return ResponseEntity.ok(tripService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Trip> getById(@PathVariable Integer id){
        return ResponseEntity.ok(tripService.findById(id));
    }

}
