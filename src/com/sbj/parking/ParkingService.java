package com.sbj.parking;

import java.util.List;
import java.util.Map;

public interface ParkingService {
	Map<ParkingLevel, List<ParkingSlot>> getAvailableSlots(ParkingType type);
	ParkingSlot allocateSlot(Vehicle vehicle);
	Ticket calculateParkingCharge(Vehicle vehicle);
}
