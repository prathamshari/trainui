package com.app.pojos;
import java.sql.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "payments")
public class Payment 
{
	private Integer paymentId;
	private Users user;
	private float amount;
	private Time paymentTime;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date paymentDate;
	private Status status;
	public Payment() {
		// TODO Auto-generated constructor stub
	}
	public Payment(float amount, Time paymentTime, Date paymentDate, Status status) 
	{
		super();
		this.amount = amount;
		this.paymentTime = paymentTime;
		this.paymentDate = paymentDate;
		this.status = status;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="user_id")
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}

	@NotNull(message="amount can not be null")
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	@NotNull(message="Payment time can not be null")
	public Time getPaymentTime() {
		return paymentTime;
	}
	public void setPaymentTime(Time paymentTime) {
		this.paymentTime = paymentTime;
	}
	
	@NotNull(message="Payment date can not be null")
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	@NotNull(message="status can not be null")
	@Enumerated(EnumType.STRING)
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", amount=" + amount + ", paymentTime=" + paymentTime
				+ ", paymentDate=" + paymentDate + ", status=" + status + "]";
	}



	
}