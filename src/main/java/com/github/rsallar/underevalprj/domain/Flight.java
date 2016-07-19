package com.github.rsallar.underevalprj.domain;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Flight {
	
	@Id
	private String id;
	private String date;
	private String price;
	private String sourceCountry;
	private String destinationCountry;
	private List<String> reservationUsers;
	private int sits;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSourceCountry() {
		return sourceCountry;
	}
	public void setSourceCountry(String sourceCountry) {
		this.sourceCountry = sourceCountry;
	}
	public String getDestinationCountry() {
		return destinationCountry;
	}
	public void setDestinationCountry(String destinationCountry) {
		this.destinationCountry = destinationCountry;
	}
	public int getSits() {
		return sits;
	}
	public void setSits(int sits) {
		this.sits = sits;
	}
	public List<String> getReservationUsers() {
		return reservationUsers;
	}
	public void setReservationUsers(List<String> reservationUsers) {
		this.reservationUsers = reservationUsers;
	}
	
	public void addReservationUser(String reservationUserId){
		reservationUsers.add(reservationUserId);
	}

	
	
}
