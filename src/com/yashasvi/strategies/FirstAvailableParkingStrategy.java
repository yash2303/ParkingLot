package com.yashasvi.strategies;

import java.util.Map;
import java.util.TreeMap;

import com.yashasvi.model.ParkingLot;
import com.yashasvi.model.ParkingSlot;
import com.yashasvi.model.SlotStatus;
import com.yashasvi.model.Ticket;
import com.yashasvi.model.Vehicle;
import com.yashasvi.model.VehicleType;

public class FirstAvailableParkingStrategy implements ParkingStrategy {

    @Override
    public ParkingSlot parkVehicle(ParkingLot parkingLot, Vehicle vehicle) {
        VehicleType vehicleType = vehicle.getVehicleType();
        TreeMap<Integer, ParkingSlot> freeSlots = parkingLot.getFreeSlots().get(vehicleType);
        TreeMap<Integer, ParkingSlot> occupiedSlots = parkingLot.getOccupiedSlots().get(vehicleType);
        if (!freeSlots.isEmpty()) {
            Map.Entry<Integer, ParkingSlot> firstAvailableSlotEntry = freeSlots.pollFirstEntry();
            Integer slotId = firstAvailableSlotEntry.getKey();
            ParkingSlot slot = firstAvailableSlotEntry.getValue();
            slot.setSlotStatus(SlotStatus.OCCUPIED);
            occupiedSlots.put(slotId, slot);
            return slot;
        }
        return null;
    }

    @Override
    public void unParkVehicle(ParkingLot parkingLot, Ticket ticket) {
        ParkingSlot parkingSlot = ticket.getParkingSlot();
        VehicleType vehicleType = ticket.getVehicle().getVehicleType();
        TreeMap<Integer, ParkingSlot> freeSlots = parkingLot.getFreeSlots().get(vehicleType);
        TreeMap<Integer, ParkingSlot> occupiedSlots = parkingLot.getOccupiedSlots().get(vehicleType);
        if (occupiedSlots.containsKey(parkingSlot.getSlotId())) {
            ticket.setOutTime();
            parkingSlot.setSlotStatus(SlotStatus.FREE);
            occupiedSlots.remove(parkingSlot.getSlotId());
            freeSlots.put(parkingSlot.getSlotId(), parkingSlot);
            System.out.println(
                "Unparked vehicle with Registration Number: " + ticket.getVehicle().getRegistrationNumber());
        } else {
            System.out.println("Invalid Ticket");
        }
    }
}
