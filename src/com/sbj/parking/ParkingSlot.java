package com.sbj.parking;

import java.util.Comparator;

public class ParkingSlot implements Comparator<ParkingSlot> {
	private String slotNumber;
	private Integer slotId;
	private Vehicle vehicleParked;
	private ParkingType parkingType;
	private boolean isEmpty = true; 
	
	public ParkingSlot(String slotNumber, ParkingType parkingType) {
		this.slotNumber = slotNumber;
		this.parkingType = parkingType;
	}
	
	public String getSlotNumber() {
		return slotNumber;
	}

	public Vehicle getVehicleParked() {
		return vehicleParked;
	}

	public ParkingType getParkingType() {
		return parkingType;
	}

	public void setParkingType(ParkingType parkingType) {
		this.parkingType = parkingType;
	}
	
	public Integer getSlotId() {
		return slotId;
	}

	public void parkVehicle(Vehicle vehicle) {
		isEmpty = false;
		vehicleParked = vehicle;
	}
	
	public void unParkVehicle() {
		isEmpty = true;
		vehicleParked = null;
	}

	@Override
	public int compare(ParkingSlot o1, ParkingSlot o2) {
		return o1.getSlotId() < o1.getSlotId() ? 1 : 0;
	}
	
}