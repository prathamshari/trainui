package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.app.pojos.Passenger;

public interface IBookingService {

	public Passenger addPassengerDetails(Passenger p);


	public Passenger getPassengerById(int pId);

	public void deletePassengerDetails(Passenger p);

	public List<Integer> getAllAvailableSeats();

	public List<Passenger> getAllPassengers(int No);

	public void updatePassenger(Passenger oldP, Passenger p);

	public void deleteAllConfirmSeats(int id);

	//public void setBookingId(int id);


	public int countPassengers(int id);

}
