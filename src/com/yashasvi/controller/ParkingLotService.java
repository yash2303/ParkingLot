package com.yashasvi.controller;

import lombok.AllArgsConstructor;

import com.yashasvi.handlers.CreateParkingLotHandler;
import com.yashasvi.handlers.DisplayHandler;
import com.yashasvi.handlers.ParkVehicleHandler;
import com.yashasvi.handlers.UnParkVehicleHandler;
import com.yashasvi.model.DisplayType;
import com.yashasvi.model.Ticket;
import com.yashasvi.model.VehicleType;

@AllArgsConstructor
public class ParkingLotService {
    private final CreateParkingLotHandler createParkingLotHandler;
    private final DisplayHandler displayHandler;
    private final ParkVehicleHandler parkVehicleHandler;
    private final UnParkVehicleHandler unParkVehicleHandler;

    public void createParkingLot(String parkingLotId, String noOfFloors, String noOfSlotsPerFloor) {
        createParkingLotHandler.createParkingLot(parkingLotId, Integer.parseInt(noOfFloors),
            Integer.parseInt(noOfSlotsPerFloor));
    }

    public void display(String parkingLotId, String displayType, String vehicleType) {
        displayHandler.display(parkingLotId, DisplayType.valueOf(displayType), VehicleType.valueOf(vehicleType));
    }

    public Ticket parkVehicle(String parkingLotId, String vehicleType, String registrationNumber, String color) {
        return parkVehicleHandler.parkVehicle(parkingLotId, VehicleType.valueOf(vehicleType), registrationNumber,
            color);
    }

    public void unParkVehicle(String parkingLotId, String ticket_id) {
        unParkVehicleHandler.unParkVehicle(parkingLotId, ticket_id);
    }
}
