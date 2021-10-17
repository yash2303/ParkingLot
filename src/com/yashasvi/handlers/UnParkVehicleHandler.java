package com.yashasvi.handlers;

import lombok.AllArgsConstructor;

import com.yashasvi.model.ParkingLot;
import com.yashasvi.model.Ticket;
import com.yashasvi.storage.DataStorage;
import com.yashasvi.strategies.ParkingStrategy;

@AllArgsConstructor
public class UnParkVehicleHandler {
    private final DataStorage dataStorage;
    private final ParkingStrategy parkingStrategy;

    public void unParkVehicle(String parkingLotId, String ticket_id) {
        ParkingLot parkingLot = dataStorage.getParkingLot(parkingLotId);
        Ticket ticket = parkingLot.getTickets().get(ticket_id);
        if (ticket == null) {
            System.out.println("Invalid Ticket");
            return;
        }
        parkingStrategy.unParkVehicle(parkingLot, ticket);
    }
}
