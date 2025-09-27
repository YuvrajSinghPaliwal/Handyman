package com.app.HandyMan.Config;

public class GeoUtils {

    private static final int EARTH_RADIUS_KM = 6371;

    public static double calculateDistance(double userLat, double userLng, double handymanLat, double handymanLng) {
        double dLat = Math.toRadians(handymanLat - userLat);
        double dLng = Math.toRadians(handymanLng - userLng);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(Math.toRadians(userLat)) * Math.cos(Math.toRadians(handymanLat)) *
                   Math.sin(dLng / 2) * Math.sin(dLng / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS_KM * c; // Distance in KM
    }
}

