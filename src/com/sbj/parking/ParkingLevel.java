package com.sbj.parking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLevel {
	private Level level;
	private Map<ParkingType, List<ParkingSlot>> totalParkingSlots;
	
	public ParkingLevel(Level level) {
		this.level = level;
	}

	public Map<ParkingType, List<ParkingSlot>> getTotalParkingSlots() {
		return totalParkingSlots;
	}

	public void setTotalParkingSlots(Map<ParkingType, List<ParkingSlot>> totalParkingSlots) {
		if(this.totalParkingSlots == null) {
			this.totalParkingSlots = new HashMap<ParkingType, List<ParkingSlot>>();
		}
		for(ParkingType parkingType :  totalParkingSlots.keySet()) {
			if(this.totalParkingSlots.containsKey(parkingType)) {
				this.totalParkingSlots.get(parkingType).addAll(totalParkingSlots.get(parkingType));
			}else {
				this.totalParkingSlots.put(parkingType, totalParkingSlots.get(parkingType));
			}
		}
	}
	
	
}
