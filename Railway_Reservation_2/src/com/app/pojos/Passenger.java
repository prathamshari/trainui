package com.app.pojos;
import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "passengers")
public class Passenger {
	private Integer passengerId;
	private String passenger_Name;
	private int age;
	private Gender gender;
	private Integer seatNo;
	private ReservationStatus status;
	private int bookingId;
	public Passenger() {
		
	}
	
	public Passenger(String passenger_Name, int age, Gender gender, ReservationStatus status) {
		super();
		this.passenger_Name = passenger_Name;
		this.age = age;
		this.gender = gender;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(Integer passengerId) {
		this.passengerId = passengerId;
	}


	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(Integer seatNo) {
		this.seatNo = seatNo;
	}
	
	@Column(length=40)
	public String getPassenger_Name() {
		return passenger_Name;
	}

	public void setPassenger_Name(String passenger_Name) {
		this.passenger_Name = passenger_Name;
	}
	
	@NotNull(message="age can not be null")
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Enumerated(EnumType.STRING)
	public ReservationStatus getStatus() {
		return status;
	}

	public void setStatus(ReservationStatus status) {
		this.status = status;
	}
	

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	


	@NotNull(message="gender can not be null")
	@Enumerated(EnumType.STRING)
	public Gender getGender() {
		return gender;
	}
	
	


	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	@Override
	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", passenger_Name=" + passenger_Name + ", age=" + age
				+ ", gender=" + gender + ", seatNo=" + seatNo + ", status=" + status + "]";
	}
	
}