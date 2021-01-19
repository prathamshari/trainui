package com.app.pojos;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "stations")
public class Station 
{
	private Integer stationId;
	private String name;
	private Trains train1;
	private Time arrivalTime;
	private int hault;
	private List<TicketPrice> routes=new ArrayList<TicketPrice>();
	public Station() {
		// TODO Auto-generated constructor stub
	}
	public Station(String name, Time arrivalTime, int hault) {
		super();
		this.name = name;
		this.arrivalTime = arrivalTime;
		this.hault = hault;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getStationId() {
		return stationId;
	}
	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}
	
	@Column(length=30)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "trainId")
	public Trains getTrain1() {
		return train1;
	}
	public void setTrain1(Trains train1) {
		this.train1 = train1;
	}
	
	@OneToMany(mappedBy = "station", cascade = CascadeType.ALL,orphanRemoval = true)
	public List<TicketPrice> getRoutes() {
		return routes;
	}

	public void setRoutes(List<TicketPrice> routes) {
		this.routes = routes;
	}

	@NotNull(message="Arrival time cannot be null")
	public Time getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	@NotNull(message="Hault time cannot be null")
	public int getHault() {
		return hault;
	}
	public void setHault(int hault) {
		this.hault = hault;
	}
	@Override
	public String toString() {
		return "Station [stationId=" + stationId + ", name=" + name + ", arrivalTime=" + arrivalTime + ", hault="
				+ hault + ", routes=" + routes + "]";
	}
	
		
	
}