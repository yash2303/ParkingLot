package com.yashasvi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Vehicle {
    private String registrationNumber;
    private String color;
    private VehicleType vehicleType;
}
