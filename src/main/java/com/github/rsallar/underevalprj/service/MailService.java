package com.github.rsallar.underevalprj.service;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.rsallar.underevalprj.repository.MailRepository;

@Service
public class MailService {
	Logger logger = LoggerFactory.getLogger(MailService.class);
	@Autowired
	MailRepository mailRepository;
	private final static String CANCEL_URL = "http://localhost:8080/openreservation?userId={1}&flightId={0}";
	
	public void sendEmail(String userId, String flightId){
		logger.info("sendig email to" + userId);
		String url = MessageFormat.format(CANCEL_URL, flightId, userId);	
		String html = "<a href="+url+">cancel reservation</a>";
		mailRepository.sendEmail(userId, "noreply@yourflightcompany.com", "", html, "your tickets information");	
	}
}
