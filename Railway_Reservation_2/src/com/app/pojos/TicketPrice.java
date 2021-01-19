package com.app.pojos;
import javax.persistence.*;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "ticketprice")
public class TicketPrice {
	private Integer ticketId;
	private float price;
	private String source;
	private String destination;
	private Station station;
	
public TicketPrice() {
	// TODO Auto-generated constructor stub
}
public TicketPrice(float price, String source, String destination) {
	super();
	this.price = price;
	this.source = source;
	this.destination = destination;
}
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public Integer getTicketId() {
	return ticketId;
}
public void setTicketId(Integer ticketId) {
	this.ticketId = ticketId;
}
@JsonIgnore
@ManyToOne
@JoinColumn(name = "stationId")
public Station getStation() {
	return station;
}

public void setStation(Station station) {
	this.station = station;
}
@NotEmpty(message="Price Must Be Supplied")
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}

@NotEmpty(message="Source Must Be Supplied")
@Column(length=35)
public String getSource() {
	return source;
}
public void setSource(String source) {
	this.source = source;
}
@NotEmpty(message="Destination Must Be Supplied")
@Column(length=35)
public String getDestination() {
	return destination;
}
public void setDestination(String destination) {
	this.destination = destination;
}
@Override
public String toString() {
	return "TicketPrice [ticketId=" + ticketId + ", price=" + price + ", source=" + source + ", destination="
			+ destination + "]";
}



}