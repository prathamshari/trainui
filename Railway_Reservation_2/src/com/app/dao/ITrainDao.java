package com.app.dao;

import java.util.List;

import com.app.pojos.Passenger;
import com.app.pojos.Trains;

public interface ITrainDao {

	Trains addTrainDetails(Trains t);

	List<Trains> getAllTrains();

	Trains getTrainById(int trainId);

	void deleteTrainDetails(Trains t);

	List<Trains> getSpecificTrainDetails(String source, String destination);

}
