package com.example.TripEvaluator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)

public class TripServiceTest {

    @Mock
    private TripRepository tripRepository;

    @InjectMocks
    private TripService tripService;

    @Test
    void shouldFindAll(){
        List<Trip> trips = new ArrayList<>();
        Trip trip = new Trip(1,"Random","random",10,null);
        trips.add(1,trip);
        Mockito.when(tripRepository.findAll())
                .thenReturn(trips);
        List<Trip> all = tripService.getAll();

        assertThat(all).hasSize(trips.size());
    }

    @Test
    void shouldDelete() {
        tripRepository.deleteById(1);

        verify(tripRepository, times(1)).deleteById(any());
    }
}
