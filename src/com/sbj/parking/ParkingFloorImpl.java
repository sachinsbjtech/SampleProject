package com.sbj.parking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class ParkingFloorImpl implements ParkingFloor {
		private List<ParkingSlot> slots;
		private Queue<ParkingSlot> slotsQ;
		private Map<Integer, ParkingSlot> occupiedSlots;
		private Level level;
		
		
		public ParkingFloorImpl(Level level) {
			this.level = level;
			slots = new ArrayList<ParkingSlot>();
			slotsQ = new PriorityQueue<ParkingSlot>();
			occupiedSlots = new HashMap<Integer, ParkingSlot>();
		}
		
		public void initiaizeParkingSlots(Map<ParkingType, Integer> parkingSlotsTobeIntialized) {
			Set<ParkingType> parkingTypeSet = parkingSlotsTobeIntialized.keySet();
			Integer uniqueParkingNUmber = 0;
			for(ParkingType parkingType : parkingTypeSet) {
				Integer capacity = parkingSlotsTobeIntialized.get(parkingType);
				for(int i = 0 ; i< capacity ;i++,uniqueParkingNUmber++) {
					slots.add(new ParkingSlot(level+"-"+uniqueParkingNUmber, parkingType));
				}
			}
			
		}
		
		private ParkingSlot getNextEmptySlot(ParkingType parkingType) {
			return null;
		}
		
		public boolean parkVehicle(Vehicle vehicle) {
			ParkingSlot toBoAllocated = slotsQ.poll();
			toBoAllocated.parkVehicle(vehicle);
			occupiedSlots.put(toBoAllocated.getSlotId(), toBoAllocated);
			return false;
		}
		
		public boolean unParkVehicle(Integer slotNumber) {
			ParkingSlot toBeVacated = occupiedSlots.remove(slotNumber);
			toBeVacated.unParkVehicle();
			slotsQ.add(toBeVacated);
			return false;
		}
		
}
