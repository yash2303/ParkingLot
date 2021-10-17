package com.yashasvi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingSlot {
    private Integer slotId;
    private SlotType slotType;
    private SlotStatus slotStatus;

    public ParkingSlot(Integer slotId, SlotType slotType) {
        this.slotId = slotId;
        this.slotType = slotType;
        this.slotStatus = SlotStatus.FREE;
    }
}
