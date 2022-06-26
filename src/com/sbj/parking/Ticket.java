package com.sbj.parking;

import java.time.LocalDateTime;

public class Ticket {
	private String ticketNumber; // Auto generated
	private Double parkigCharge;
	private LocalDateTime inTime;
	private LocalDateTime outTime;
	private Vehicle vehicle;
	
	public Ticket(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public Double getParkigCharge() {
		return parkigCharge;
	}
	public void setParkigCharge(Double parkigCharge) {
		this.parkigCharge = parkigCharge;
	}
	public String getTicketNumber() {
		return ticketNumber;
	}
	public void setInTime(LocalDateTime inTime) {
		this.inTime = inTime;
	}
	public void setOutTime(LocalDateTime outTime) {
		this.outTime = outTime;
	}
	
	
	
	
}
