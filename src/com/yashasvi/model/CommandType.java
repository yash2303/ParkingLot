package com.yashasvi.model;

import lombok.Getter;

@Getter
public enum CommandType {
    CREATE_PARKING_LOT("create_parking_lot"), PARK_VEHICLE("park_vehicle"), UNPARK_VEHICLE("unpark_vehicle"), DISPLAY(
        "display"), EXIT("exit");
    private final String type;

    CommandType(String type) {
        this.type = type;
    }
}
