package com.github.rsallar.underevalprj.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.github.rsallar.underevalprj.domain.Flight;

public interface FlightRepository extends CrudRepository<Flight, Long> {

    List<Flight> findByDateAndSourceCountryAndDestinationCountry(String date,String sourceCountry, String destinationCountry, Pageable pageable);
}