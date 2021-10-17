package com.yashasvi.handlers;

import lombok.AllArgsConstructor;

import com.yashasvi.model.ParkingSlot;
import com.yashasvi.model.Ticket;
import com.yashasvi.model.Vehicle;
import com.yashasvi.model.VehicleType;
import com.yashasvi.storage.DataStorage;
import com.yashasvi.strategies.ParkingStrategy;

@AllArgsConstructor
public class ParkVehicleHandler {
    private final DataStorage dataStorage;
    private final ParkingStrategy parkingStrategy;

    public Ticket parkVehicle(String parkingLotId, VehicleType vehicleType, String registrationNumber, String color) {
        Vehicle vehicle = new Vehicle(registrationNumber, color, vehicleType);
        ParkingSlot parkingSlot = parkingStrategy.parkVehicle(dataStorage.getParkingLot(parkingLotId), vehicle);
        if (parkingSlot == null) {
            System.out.println("Parking Lot Full");
            return null;
        }
        Ticket ticket = new Ticket(parkingLotId, vehicle, parkingSlot);
        dataStorage.addTicket(parkingLotId, ticket);
        System.out.println("Vehicle parked successfully with ticket: " + ticket);
        return ticket;
    }
}
