package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Passenger;
import com.app.pojos.Users;
import com.app.service.IBookingService;

@RestController // @Controller + @RespBody
@CrossOrigin//(origins="http://localhost:4200")
@RequestMapping("/bookings")
public class BookingController 
{
	@Autowired
	private IBookingService service;

	
	@PostConstruct
	public void init() 
	{
		System.out.println("in init " + service);
	}

	
	@GetMapping("/AvailableSeats")
	public ResponseEntity<?> seatList() 
	{
		System.out.println("in list of bokings");
		List<Integer> allSeats = service.getAllAvailableSeats();
		if (allSeats .size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Integer>>(allSeats , HttpStatus.OK);
	}
	
	@GetMapping("/passengerslist/{No}")
	public ResponseEntity<?> getAllPassengers(@PathVariable int No)
	{
		System.out.println("in list of passengers "+No);
		List<Passenger> allSeats = service.getAllPassengers(No);
		for(Passenger p:allSeats)
		{
			System.out.println(p.toString());
		}
		if (allSeats .size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Passenger>>(allSeats , HttpStatus.OK);	
	}

	//add passengers + set booking id
	@PostMapping("/passengers/{id}")
	public ResponseEntity<?> addPassenger(@RequestBody Passenger p,@PathVariable int id) 
	{
		System.out.println("booking id is : "+id);
		System.out.println("in add Passengers " + p);
		p.setBookingId(id);
		try 
		{
			return new ResponseEntity<Passenger>(service.addPassengerDetails(p), HttpStatus.CREATED);
		} 
		catch (RuntimeException e1)
		{
			e1.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/passengers/{pId}")
	public ResponseEntity<?> getPassengerById(@PathVariable int pId)
	{
		  System.out.println("in Get Passengers : "+pId);
		  Passenger u =service.getPassengerById(pId); 
		  if (u == null) 
			  return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); 
		  return new ResponseEntity<Passenger>(u, HttpStatus.OK); 
	}
	
	@DeleteMapping("/passengers/{pId}")
	public void deletePassengerDetails(@PathVariable int pId)
	{
		System.out.println("in delete admin "+pId);
		Passenger p=service.getPassengerById(pId);
		service.deletePassengerDetails(p);
	}
	
	@PutMapping("/passengers/{pId}")
	public void updateUserDetails(@PathVariable int pId,@RequestBody Passenger p) {
		p.setPassengerId(pId);
		System.out.println("in add user dtls " + p);
		Passenger oldP=service.getPassengerById(pId);
		       service.updatePassenger(oldP,p);
	}
	
	@DeleteMapping("/deleteAllConfirmSeats/{id}")
	public void deleteAllConfirmSeats(@PathVariable int id)
	{
		System.out.println("id :"+id);
		service.deleteAllConfirmSeats(id);
	}
	
	@GetMapping("/countPassengers/{id}")
	public int countPassengers(@PathVariable int id)
	{
		System.out.println("booking number of passengers is : "+id);
		return service.countPassengers(id);
	}
}
	
	