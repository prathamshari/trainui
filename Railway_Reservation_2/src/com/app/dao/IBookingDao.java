package com.app.dao;

import java.util.List;


import com.app.pojos.Passenger;

public interface IBookingDao {

	public Passenger addPassengers(Passenger p);



	public Passenger getPassengerById(int pId);

	public void deletePassengerDetails(Passenger p);

	public List<Integer> getAllAvailableSeats();

	public List<Passenger> getAllPassengers(int No);

	public void updatePassenger(Passenger oldP, Passenger p);

	public void deleteAllConfirmSeats(int id);


	public int countPassengers(int id);

}
