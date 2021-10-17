package com.yashasvi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.yashasvi.handlers.CreateParkingLotHandler;
import com.yashasvi.handlers.DisplayHandler;
import com.yashasvi.handlers.ParkVehicleHandler;
import com.yashasvi.factory.ParkingLotFactory;
import com.yashasvi.controller.ParkingLotService;
import com.yashasvi.handlers.UnParkVehicleHandler;
import com.yashasvi.model.Command;
import com.yashasvi.model.CommandType;
import com.yashasvi.storage.DataStorage;
import com.yashasvi.storage.InMemoryDataStorage;
import com.yashasvi.strategies.FirstAvailableParkingStrategy;
import com.yashasvi.strategies.ParkingStrategy;

public class Main {

    public static void main(String[] args) throws IOException {
        DataStorage dataStorage = new InMemoryDataStorage();
        ParkingStrategy parkingStrategy = new FirstAvailableParkingStrategy();
        ParkingLotFactory parkingLotFactory = new ParkingLotFactory();
        CreateParkingLotHandler createParkingLotHandler = new CreateParkingLotHandler(dataStorage, parkingLotFactory);
        DisplayHandler displayHandler = new DisplayHandler(dataStorage);
        ParkVehicleHandler parkVehicleHandler = new ParkVehicleHandler(dataStorage, parkingStrategy);
        UnParkVehicleHandler unParkVehicleHandler = new UnParkVehicleHandler(dataStorage, parkingStrategy);
        ParkingLotService parkingLotService =
            new ParkingLotService(createParkingLotHandler, displayHandler, parkVehicleHandler, unParkVehicleHandler);
        String parkingLotId = "";

        System.out.println("Starting parking lot service !");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = reader.readLine();
            Command command = new Command(input);
            List<String> params = command.getParams();
            if (CommandType.CREATE_PARKING_LOT.getType().equals(command.getCommandName())) {
                parkingLotId = params.get(0);
                parkingLotService.createParkingLot(params.get(0), params.get(1), params.get(2));
            } else if (CommandType.DISPLAY.getType().equals(command.getCommandName())) {
                parkingLotService.display(parkingLotId, params.get(0), params.get(1));
            } else if (CommandType.PARK_VEHICLE.getType().equals(command.getCommandName())) {
                parkingLotService.parkVehicle(parkingLotId, params.get(0), params.get(1), params.get(2));
            } else if (CommandType.UNPARK_VEHICLE.getType().equals(command.getCommandName())) {
                parkingLotService.unParkVehicle(parkingLotId, params.get(0));
            } else if (CommandType.EXIT.getType().equals(command.getCommandName())){
                System.out.println("Shutting down parking lot service !");
                break;
            }
        }
    }
}
