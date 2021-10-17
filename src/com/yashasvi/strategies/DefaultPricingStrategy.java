package com.yashasvi.strategies;

import java.util.Date;

import com.yashasvi.model.Ticket;

public class DefaultPricingStrategy implements PricingStrategy {
    @Override
    public double getPrice(Ticket ticket) {
        Date inTime = ticket.getInTime();
        Date outTime = ticket.getOutTime();
        long hours = (outTime.getTime() - inTime.getTime()) / (60 * 60 * 1000) + 1;
        return hours * ticket.getParkingSlot().getSlotType().getPricePerHour();
    }
}
