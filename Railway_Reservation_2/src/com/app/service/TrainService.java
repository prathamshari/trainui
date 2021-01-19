package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ITrainDao;
import com.app.pojos.Passenger;
import com.app.pojos.Trains;
import com.app.pojos.Users;

@Service
@Transactional
public class TrainService implements ITrainService
{
	@Autowired
	private ITrainDao dao;
	
	@Override
	public Trains addTrainDetails(Trains t) {
		System.out.println("Inside Service()");
		// TODO Auto-generated method stub
			return dao.addTrainDetails(t);
	}

	@Override
	public List<Trains> getAllTrains() {
		// TODO Auto-generated method stub
		return dao.getAllTrains();
	}

	@Override
	public Trains getTrainById(int trainId) {
		// TODO Auto-generated method stub
		return dao.getTrainById(trainId);
	}

	@Override
	public void deleteTrainDetails(Trains t) {
		dao.deleteTrainDetails(t);
		
	}

	@Override
	public List<Trains> getSpecificTrainDetails(String source, String destination) {
		System.out.println("souec : " + source +" Destination : "+destination);
		return dao.getSpecificTrainDetails(source, destination);
	}
	

}
