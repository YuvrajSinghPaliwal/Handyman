package com.app.HandyMan.Dtos;

import com.app.HandyMan.Entity.Handyman;

public class HandymanDistanceDto {
	
    private Handyman handyman;
    private double distance; // in KM

    public HandymanDistanceDto(Handyman handyman, double distance) {
        this.handyman = handyman;
        this.distance = distance;
    }

    public Handyman getHandyman() {
        return handyman;
    }

    public double getDistance() {
        return distance;
    }
}

