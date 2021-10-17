package com.yashasvi.model;

import static com.yashasvi.util.Constants.MAX_SLOTS_ON_A_FLOOR;

import java.util.Date;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Ticket {
    private final String ticketId;
    private final Vehicle vehicle;
    private final ParkingSlot parkingSlot;
    private final Date inTime;
    private Date outTime;
    private long price;

    public Ticket(String parkingLotId, Vehicle vehicle, ParkingSlot parkingSlot) {
        int floorNumber = parkingSlot.getSlotId() / MAX_SLOTS_ON_A_FLOOR;
        int slotNumber = parkingSlot.getSlotId() % MAX_SLOTS_ON_A_FLOOR;
        this.ticketId = parkingLotId + "_" + floorNumber + "_" + slotNumber;
        this.vehicle = vehicle;
        this.parkingSlot = parkingSlot;
        this.inTime = new Date();
        this.outTime = null;
        this.price = 0;
    }

    public void setOutTime() {
        this.outTime = new Date();
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
