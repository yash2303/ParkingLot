package com.yashasvi.handlers;

import java.util.TreeMap;

import lombok.AllArgsConstructor;

import com.yashasvi.model.DisplayType;
import com.yashasvi.model.ParkingLot;
import com.yashasvi.model.ParkingSlot;
import com.yashasvi.model.VehicleType;
import com.yashasvi.storage.DataStorage;

@AllArgsConstructor
public class DisplayHandler {
    private final DataStorage dataStorage;

    public void display(String parkingLotId, DisplayType displayType, VehicleType vehicleType) {
        ParkingLot parkingLot = dataStorage.getParkingLot(parkingLotId);
        TreeMap<Integer, ParkingSlot> occupiedSlots = parkingLot.getOccupiedSlots().get(vehicleType);
        TreeMap<Integer, ParkingSlot> freeSlots = parkingLot.getFreeSlots().get(vehicleType);
        if (DisplayType.free_count.equals(displayType)) {
            System.out.printf("No. of free slots for %s: %s%n", vehicleType, freeSlots.size());
        } else if (DisplayType.free_slots.equals(displayType)) {
            System.out.printf("Free slots for %s: %s%n", vehicleType, freeSlots.keySet());
        } else if (DisplayType.occupied_slots.equals(displayType)) {
            System.out.printf("Occupied slots for %s: %s%n", vehicleType, occupiedSlots.keySet());
        } else {
            System.out.println("Invalid display type");
        }
    }
}
