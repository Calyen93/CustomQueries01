package com.example.customQueries01.repositories;

import com.example.customQueries01.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
