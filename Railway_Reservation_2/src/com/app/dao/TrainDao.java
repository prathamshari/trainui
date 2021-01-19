package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Passenger;
import com.app.pojos.Trains;
import com.app.pojos.Users;

import java.util.List;

import org.hibernate.SessionFactory;


@Repository
public class TrainDao implements ITrainDao
{
	@Autowired 
	private SessionFactory sf;
	@Override
	public Trains addTrainDetails(Trains t) {
		// TODO Auto-generated method stub
		System.out.println("Inside Dao()");
		System.out.println("Details:"+t);
		sf.getCurrentSession().persist(t);
		return t;
	}
	@Override
	public List<Trains> getAllTrains() {
		String jpql="select t from Trains t";
		return sf.getCurrentSession().createQuery(jpql,Trains.class).getResultList();
	}
	@Override
	public Trains getTrainById(int trainId) {
		Trains t=new Trains();
		t=sf.getCurrentSession().get(Trains.class, trainId);
		System.out.println("in dao :"+t.toString());
		return t;
	}
	@Override
	public void deleteTrainDetails(Trains t) {
		sf.getCurrentSession().delete(t);
		
	}
	
	@Override
	public List<Trains> getSpecificTrainDetails(String source, String destination) {
		System.out.println("souec : " + source +" Destination : "+destination);
		String jpql="select t from Trains t where t.source=:s and t.destination=:d";
		return sf.getCurrentSession().createQuery(jpql,Trains.class).setParameter("s", source).setParameter("d", destination).getResultList();
	}
	
	


}
