package com.yashasvi.strategies;

import com.yashasvi.model.Ticket;

public interface PricingStrategy {
    double getPrice(Ticket ticket);
}
