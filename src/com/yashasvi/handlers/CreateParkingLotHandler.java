package com.yashasvi.handlers;

import lombok.AllArgsConstructor;

import com.yashasvi.factory.ParkingLotFactory;
import com.yashasvi.model.ParkingLot;
import com.yashasvi.storage.DataStorage;

@AllArgsConstructor
public class CreateParkingLotHandler {
    private final DataStorage dataStorage;
    private final ParkingLotFactory parkingLotFactory;

    public void createParkingLot(String parkingLotId, int noOfFloors, int noOfSlotsPerFloor) {
        ParkingLot parkingLot = parkingLotFactory.buildParkingLot(parkingLotId, noOfFloors, noOfSlotsPerFloor);
        dataStorage.addParkingLot(parkingLot);
        System.out.println("Parking lot created successfully");
    }
}
