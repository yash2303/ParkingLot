package com.yashasvi.storage;

import com.yashasvi.model.ParkingLot;
import com.yashasvi.model.Ticket;

public interface DataStorage {
    void addParkingLot(ParkingLot parkingLot);
    ParkingLot getParkingLot(String parkingLotId);
    void addTicket(String parkingLotId, Ticket ticket);
}
