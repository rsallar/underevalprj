package com.github.rsallar.underevalprj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.social.security.SocialUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.rsallar.underevalprj.service.ReservationService;

@RestController
@RequestMapping("/openreservation")

public class ReservationOpenController {
	
	@Autowired
	private ReservationService service;
		
	@RequestMapping(method = RequestMethod.GET)
	public Boolean cancelReservation(@RequestParam String flightId,	@RequestParam String userId){
		return service.deleteReservation(flightId, userId);
	}
	
}
