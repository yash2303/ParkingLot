package com.yashasvi.storage;

import java.util.concurrent.ConcurrentHashMap;

import com.yashasvi.model.ParkingLot;
import com.yashasvi.model.Ticket;

public class InMemoryDataStorage implements DataStorage {
    private final ConcurrentHashMap<String, ParkingLot> parkingLots;

    public InMemoryDataStorage() {
        parkingLots = new ConcurrentHashMap<>();
    }

    @Override
    public void addParkingLot(ParkingLot parkingLot) {
        parkingLots.put(parkingLot.getParkingLotId(), parkingLot);
    }

    @Override
    public ParkingLot getParkingLot(String parkingLotId) {
        return parkingLots.get(parkingLotId);
    }

    @Override
    public void addTicket(String parkingLotId, Ticket ticket) {
        parkingLots.get(parkingLotId).getTickets().put(ticket.getTicketId(), ticket);
    }
}
