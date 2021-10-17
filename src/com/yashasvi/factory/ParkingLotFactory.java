package com.yashasvi.factory;

import static com.yashasvi.util.Constants.MAX_SLOTS_ON_A_FLOOR;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import com.yashasvi.model.Floor;
import com.yashasvi.model.ParkingLot;
import com.yashasvi.model.ParkingSlot;
import com.yashasvi.model.SlotType;
import com.yashasvi.model.VehicleType;

public class ParkingLotFactory {
    public ParkingLot buildParkingLot(String parkingLotId, int noOfFloors, int noOfSlotsPerFloor) {
        List<Floor> floors = new ArrayList<>();
        ConcurrentHashMap<VehicleType, TreeMap<Integer, ParkingSlot>> freeSlots = new ConcurrentHashMap<>();
        ConcurrentHashMap<VehicleType, TreeMap<Integer, ParkingSlot>> occupiedSlots =
            buildVehicleTypeTreeMapConcurrentHashMap();
        for (int floorNumber = 1; floorNumber <= noOfFloors; floorNumber++) {
            List<ParkingSlot> parkingSlots = new ArrayList<>();
            for (int slotNumber = 1; slotNumber <= noOfSlotsPerFloor; slotNumber++) {
                ParkingSlot parkingSlot;
                int slotId = MAX_SLOTS_ON_A_FLOOR * floorNumber + slotNumber;
                if (slotNumber == 1) {
                    parkingSlot = new ParkingSlot(slotId, SlotType.TRUCK_SLOT);
                    freeSlots.computeIfAbsent(VehicleType.TRUCK, k -> new TreeMap<>()).put(slotId, parkingSlot);
                } else if (slotNumber == 2 || slotNumber == 3) {
                    parkingSlot = new ParkingSlot(slotId, SlotType.BIKE_SLOT);
                    freeSlots.computeIfAbsent(VehicleType.BIKE, k -> new TreeMap<>()).put(slotId, parkingSlot);
                } else {
                    parkingSlot = new ParkingSlot(slotId, SlotType.CAR_SLOT);
                    freeSlots.computeIfAbsent(VehicleType.CAR, k -> new TreeMap<>()).put(slotId, parkingSlot);
                }
                parkingSlots.add(parkingSlot);
            }
            floors.add(new Floor(parkingSlots));
        }
        return ParkingLot.builder()
            .parkingLotId(parkingLotId)
            .floors(floors)
            .freeSlots(freeSlots)
            .occupiedSlots(occupiedSlots)
            .tickets(new ConcurrentHashMap<>())
            .build();
    }

    private ConcurrentHashMap<VehicleType, TreeMap<Integer, ParkingSlot>> buildVehicleTypeTreeMapConcurrentHashMap() {
        ConcurrentHashMap<VehicleType, TreeMap<Integer, ParkingSlot>> vehicleTypeTreeMapConcurrentHashMap =
            new ConcurrentHashMap<>();
        vehicleTypeTreeMapConcurrentHashMap.put(VehicleType.BIKE, new TreeMap<>());
        vehicleTypeTreeMapConcurrentHashMap.put(VehicleType.CAR, new TreeMap<>());
        vehicleTypeTreeMapConcurrentHashMap.put(VehicleType.TRUCK, new TreeMap<>());
        return vehicleTypeTreeMapConcurrentHashMap;
    }

}
