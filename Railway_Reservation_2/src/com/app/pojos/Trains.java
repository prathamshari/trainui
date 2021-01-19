package com.app.pojos;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
@Entity
@Table(name="trains")
public class Trains {
	private Integer train_Id;
	private String source;
	private String destination;
	private String trainName;
	private String arrivalTime;
	private String departureTime;
	private String reachTime;
	private int capacity;
	private List<Station> stations=new ArrayList<Station>();
	private float price;
	
	public Trains() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getTrain_Id() {
		return train_Id;
	}
	public void setTrain_Id(Integer train_Id) {
		this.train_Id = train_Id;
	}
	@JsonIgnore
	@OneToMany(mappedBy = "train1", cascade = CascadeType.ALL,orphanRemoval = true)
	public List<Station> getStations() {
		return stations;
	}
	
	public void setStations(List<Station> stations) {
		this.stations = stations;
	}
	
	@Column(length = 35)
	@NotEmpty(message="Source Can Not Be Empty")
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	@Column(length = 35)
	@NotEmpty(message="Destination Can Not Be Empty")
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	@Column(length = 35)
	@NotEmpty(message="Train Name Can Not Be Empty")
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	
	@NotEmpty(message="Arrival Time Can Not Be Empty")
	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	@NotEmpty(message="Departure Time Can Not Be Empty")
	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	@NotEmpty(message="Reach Time Can Not Be Empty")
	public String getReachTime() {
		return reachTime;
	}

	public void setReachTime(String reachTime) {
		this.reachTime = reachTime;
	}

	@Range(min=0, max=90)
	@Column(name = "capacity", unique = true, nullable = false)
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Trains [train_Id=" + train_Id + ", source=" + source + ", destination=" + destination + ", trainName="
				+ trainName + ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime + ", reachTime="
				+ reachTime + ", capacity=" + capacity + ", stations=" + stations + ", price=" + price + "]";
	}
}
