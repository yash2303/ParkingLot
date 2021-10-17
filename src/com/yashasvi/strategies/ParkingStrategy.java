package com.yashasvi.strategies;

import com.yashasvi.model.ParkingLot;
import com.yashasvi.model.ParkingSlot;
import com.yashasvi.model.Ticket;
import com.yashasvi.model.Vehicle;

public interface ParkingStrategy {
    ParkingSlot parkVehicle(ParkingLot parkingLot, Vehicle vehicle);
    void unParkVehicle(ParkingLot parkingLot, Ticket ticket);
}
