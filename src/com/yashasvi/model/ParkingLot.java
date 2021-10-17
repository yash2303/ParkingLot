package com.yashasvi.model;

import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ParkingLot {
    private String parkingLotId;
    private List<Floor> floors;
    private ConcurrentHashMap<VehicleType, TreeMap<Integer, ParkingSlot>> freeSlots;
    private ConcurrentHashMap<VehicleType, TreeMap<Integer, ParkingSlot>> occupiedSlots;
    private ConcurrentHashMap<String, Ticket> tickets;
}
