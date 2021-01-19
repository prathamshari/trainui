package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IBookingDao;
import com.app.pojos.Passenger;

@Service
@Transactional
public class BookingService implements IBookingService
{
	@Autowired
	IBookingDao dao;
	
	@Override
	public Passenger addPassengerDetails(Passenger p) {
		return dao.addPassengers(p);
	}


	@Override
	public Passenger getPassengerById(int pId) {
		// TODO Auto-generated method stub
		return dao.getPassengerById(pId);
	}

	@Override
	public void deletePassengerDetails(Passenger p) {
		dao.deletePassengerDetails(p);
		
	}

	@Override
	public List<Integer> getAllAvailableSeats() {
		// TODO Auto-generated method stub
		return dao.getAllAvailableSeats();
	}

	@Override
	public List<Passenger> getAllPassengers(int No) {
		// TODO Auto-generated method stub
		return dao.getAllPassengers(No);
	}

	@Override
	public void updatePassenger(Passenger oldP, Passenger p) {
		dao.updatePassenger(oldP,p);
		
	}

	@Override
	public void deleteAllConfirmSeats(int id) {
		dao.deleteAllConfirmSeats(id);
		
	}

	//@Override
	/*
	 * public void setBookingId(int id) { dao.setBookingId(id);
	 * 
	 * }
	 */


	@Override
	public int countPassengers(int id) {
		return dao.countPassengers(id);
		
	}

}
