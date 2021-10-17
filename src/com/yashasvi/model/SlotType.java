package com.yashasvi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SlotType {
    CAR_SLOT(10, 10), BIKE_SLOT(20, 20), TRUCK_SLOT(30, 30);
    private double basePrice;
    private double pricePerHour;
}
