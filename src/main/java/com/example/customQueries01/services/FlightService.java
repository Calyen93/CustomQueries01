package com.example.customQueries01.services;

import com.example.customQueries01.models.Flight;
import com.example.customQueries01.models.enums.Status;
import com.example.customQueries01.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public List<Flight> provisionFlights() {
        Random random = new Random();
        List<Flight> flights = IntStream.rangeClosed(1, 50)
                .mapToObj(i -> new Flight("Flight " + i, "Airport " + random.ints(97, 123)
                        .limit(3)
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString(),
                        "Airport " + random.ints(97, 123)
                                .limit(3)
                                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                                .toString()))
                .collect(Collectors.toList());
        flights.forEach(flight -> flight.setStatus(Status.ON_TIME));
        return flightRepository.saveAll(flights);
    }
}
