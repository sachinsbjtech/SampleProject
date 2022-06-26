package com.sbj.parking;

public class Vehicle {
	private String vehicleNumber;
	private Double chargeToPay;
	private VehicleType vehicleType;
	
	public Vehicle(String vehicleNumber,VehicleType vehicleType) {
		this.vehicleNumber = vehicleNumber;
		this.vehicleType = vehicleType;
	}

	public Double getChargeToPay() {
		return chargeToPay;
	}

	public void setChargeToPay(Double chargeToPay) {
		this.chargeToPay = chargeToPay;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}
	
	public enum VehicleType{
		TWO,FOUR;
	}
}
