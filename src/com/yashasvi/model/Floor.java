package com.yashasvi.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Floor {
    private List<ParkingSlot> parkingSlots;
}
