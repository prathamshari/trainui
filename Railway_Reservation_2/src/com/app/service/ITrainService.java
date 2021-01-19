package com.app.service;

import java.util.List;

import com.app.pojos.Passenger;
import com.app.pojos.Trains;
import com.app.pojos.Users;

public interface ITrainService {

	Trains addTrainDetails(Trains t);

	List<Trains> getAllTrains();

	Trains getTrainById(int trainId);

	void deleteTrainDetails(Trains t);

	List<Trains> getSpecificTrainDetails(String source, String destination);

}
