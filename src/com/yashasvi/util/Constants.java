package com.yashasvi.util;

import java.util.Map;

import com.yashasvi.model.SlotType;

public class Constants {
    public static int MAX_SLOTS_ON_A_FLOOR = 10000;
    public static Map<SlotType, Integer> SLOT_PRICE_PER_HOUR = Map.of(
        SlotType.BIKE_SLOT, 10,
        SlotType.CAR_SLOT, 20,
        SlotType.TRUCK_SLOT, 30
    );
}
