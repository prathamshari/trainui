package com.app.controller;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.app.pojos.Passenger;
import com.app.pojos.Trains;
//import com.app.pojos.Users;
import com.app.service.ITrainService;

@RestController
@CrossOrigin
@RequestMapping("/trains")
public class TrainController {
	
	@Autowired
	private ITrainService service;
	
	@PostMapping
	public ResponseEntity<?> addTrainDetails(@RequestBody Trains t) 
	{
		System.out.println("in add train");
		System.out.println("in add Passengers " + t);
		//LocalTime l1=LocalTime.of(hour, minute)
		try 
		{
			return new ResponseEntity<Trains>(service.addTrainDetails(t), HttpStatus.CREATED);
		} 
		catch (RuntimeException e1)
		{
			e1.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping
	public ResponseEntity<?> listTrains() {
		System.out.println("in list emps");
		List<Trains> allTrains = service.getAllTrains();
		if (allTrains.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Trains>>(allTrains, HttpStatus.OK);
	}
	
	@GetMapping("/{trainId}")
	public ResponseEntity<?> getTrainDetails(@PathVariable int trainId){ 	
		System.out.println("in emp dtls " + trainId); 
		Trains u =service.getTrainById(trainId); 
		if (u == null) 
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); 
		return new ResponseEntity<Trains>(u, HttpStatus.OK); 
		}

	@DeleteMapping("/{trainId}")
	public void deleteEmpDetails(@PathVariable int trainId)
	{
		System.out.println("in delete admin "+trainId);
		Trains t=service.getTrainById(trainId);
		service.deleteTrainDetails(t);
	}
	
	@GetMapping("/{source}/{destination}")
	public ResponseEntity<?> getSpecificTrainDetails(@PathVariable String source,@PathVariable String destination){ 	
		System.out.println("souec : " + source +" Destination : "+destination); 
		List<Trains> t =new ArrayList<>();
		t=service.getSpecificTrainDetails(source,destination); 
		if (t == null) 
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); 
		return new ResponseEntity<List<Trains>>(t, HttpStatus.OK); 
		}
	

	

}
