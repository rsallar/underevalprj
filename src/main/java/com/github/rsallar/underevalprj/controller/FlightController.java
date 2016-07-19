package com.github.rsallar.underevalprj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.rsallar.underevalprj.domain.Flight;
import com.github.rsallar.underevalprj.domain.FlightCriteria;
import com.github.rsallar.underevalprj.service.ReservationService;

@RestController
@RequestMapping("/flights")

public class FlightController {
	
	@Autowired
	private ReservationService service;
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Flight> findFlights(@RequestBody @Validated FlightCriteria flightCriteria ){
		return service.findFlights(flightCriteria);
	}
	
	

}
