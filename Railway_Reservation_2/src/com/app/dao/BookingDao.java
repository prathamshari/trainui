package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Passenger;
import com.app.pojos.Trains;
import com.app.pojos.Users;
@Repository
public class BookingDao implements IBookingDao
{
	
	@Autowired 
	private SessionFactory sf;

	@Override
	public Passenger addPassengers(Passenger p) {
		
		sf.getCurrentSession().persist(p);
		return p;
	}


	@Override
	public Passenger getPassengerById(int pId) {
		String jpql="select p from Passenger p where p.passengerId=:ID";
		return sf.getCurrentSession().createQuery(jpql,Passenger.class).setParameter("ID",pId).getSingleResult();
	}

	@Override
	public void deletePassengerDetails(Passenger p) {
		sf.getCurrentSession().delete(p);
		
	}

	@Override
	public List<Integer> getAllAvailableSeats() {
		List <Integer> list=new ArrayList<>();
		for(int i=1;i<=50;i++)
		{
			String jpql="select p from Passenger p where p.seatNo=:no";
			try
			{
				Passenger p=sf.getCurrentSession().createQuery(jpql,Passenger.class).setParameter("no", i).getSingleResult();
			}
			catch(NoResultException e)
			{
				list.add(i);
			}
			
		}
		for(Integer j:list)
		{
			System.out.println(j);
		}
		
		return list;
	}

	@Override
	public List<Passenger> getAllPassengers(int No) {
		List<Passenger> l1,l2=new ArrayList<>();
		String jpql="select p from Passenger p";
		l1= sf.getCurrentSession().createQuery(jpql,Passenger.class).getResultList();
		for(Passenger p : l1)
		{
			if(p.getBookingId()==No)
				l2.add(p);
		}
		return l2;
	}

	@Override
	public void updatePassenger(Passenger oldP, Passenger p) {
		oldP.setAge(p.getAge());
		oldP.setPassenger_Name(p.getPassenger_Name());
		sf.getCurrentSession().update(oldP);
		
	}

	@Override
	public void deleteAllConfirmSeats(int id) {
		System.out.println("id in dao : "+id);
		String jpql="delete p from Passenger p where p.bookingId=:id";
		sf.getCurrentSession().createQuery(jpql,Passenger.class).setParameter("id", id);
		
	}


	@Override
	public int countPassengers(int id) {
		System.out.println(id);
		int size=0;
		//String jpql="select COUNT(P) from Passenger P where P.BookingId=:id";
		String jpql="select P from Passenger P";
		List<Passenger> l1=sf.getCurrentSession().createQuery(jpql,Passenger.class).getResultList();
		for (Passenger passenger : l1) {
			System.out.println(passenger.toString());
			System.out.println("booking id is : "+passenger.getBookingId());
			if(passenger.getBookingId()==id)
			size++;
		}
		System.out.println("size of set is : "+size);
		return size;
	}



	

}
