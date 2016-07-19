package com.github.rsallar.underevalprj.service;

import java.time.LocalDate;
import java.time.Month;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import com.github.rsallar.underevalprj.domain.Client;
import com.github.rsallar.underevalprj.domain.Flight;
import com.github.rsallar.underevalprj.domain.Roles;
import com.github.rsallar.underevalprj.repository.ClientRepository;
import com.github.rsallar.underevalprj.repository.FlightRepository;

@Service
public class InitService {
	
	static Logger logger = LoggerFactory.getLogger(InitService.class);

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private FlightRepository flightRepository;
	
	@PostConstruct
    public void init() {
		logger.info("Adding mocking user to demo purposes");
		Client client = new Client("admin@test.com", AuthorityUtils.createAuthorityList(Roles.USER));	
		clientRepository.save(client);
    
		createFlight1();
			
		flightRepository.save(createFlight1());
		flightRepository.save(createFlight2());
		flightRepository.save(createFlight3());
		
	}
	
	
	private Flight createFlight1(){
		Flight flight = new Flight();
		flight.setId("flight1");
		flight.setDate(LocalDate.of(2016, Month.DECEMBER, 12).toString());
		flight.setDestinationCountry("Spain");
		flight.setSourceCountry("France");
		flight.setPrice("60");
		flight.setSits(100);
		return flight;
	}
	
	private Flight createFlight2(){
		Flight flight = new Flight();
		flight.setId("flight2");
		flight.setDate(LocalDate.of(2016, Month.OCTOBER, 25).toString());
		flight.setDestinationCountry("Spain");
		flight.setSourceCountry("Italy");
		flight.setPrice("100");
		flight.setSits(100);
		return flight;
	}
	
	private Flight createFlight3(){
		Flight flight = new Flight();
		flight.setId("flight3");
		flight.setDate(LocalDate.of(2016, Month.OCTOBER, 25).toString());
		flight.setDestinationCountry("Spain");
		flight.setSourceCountry("Italy");
		flight.setPrice("100");
		flight.setSits(0);
		return flight;
	}
	
}
