package com.github.rsallar.underevalprj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.github.rsallar.underevalprj.domain.Flight;
import com.github.rsallar.underevalprj.domain.FlightCriteria;
import com.github.rsallar.underevalprj.repository.FlightRepository;
import com.mongodb.WriteResult;

@Service
public class ReservationService {


	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private MongoOperations mongoOperations;

      
    public List<Flight> findFlights(FlightCriteria criteria){
      	
    	return flightRepository.findByDateAndSourceCountryAndDestinationCountry(criteria.getDate(), criteria.getSourceCountry(), criteria.getDestinationCountry(), new PageRequest(0, 20));
    }
    
    public boolean createReservationAndSendEmail(String flightId, String userId){
    	
    	WriteResult result = mongoOperations.updateFirst(new Query(Criteria.where("id").is(flightId)).addCriteria(Criteria.where("sits").gt(0)),
    			new Update().push("reservationUsers", userId).inc("sits", -1)
    			, Flight.class);
    	
    	if(result.isUpdateOfExisting()){
    		mailService.sendEmail(userId, flightId);
    	}
    	
    	return result.isUpdateOfExisting();

    }

	public boolean deleteReservation(String flightId, String userId) {
		
		WriteResult result = mongoOperations.updateFirst(new Query(Criteria.where("id").is(flightId)).addCriteria(Criteria.where("reservationUsers").in(userId)),
    			new Update().pull("reservationUsers", userId).inc("sits", 1)
    			, Flight.class);
		
		return result.isUpdateOfExisting();
	}
  
   /*public Hotel findHotelById(Long id);

    
    public Booking createBooking(Long hotelId, String userName);

   
    public void persistBooking(Booking booking);

   
    public void cancelBooking(Long id);
*/
}