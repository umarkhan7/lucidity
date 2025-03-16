package com.deliveryoptimizer.service;

import org.springframework.stereotype.Service;

@Service
public class RouteService {

    public double calculateShortestRoute(double[] driverLocation, double speed, double[] r1, double[] c1, double[] r2, double[] c2, double pt1, double pt2) {

        // Calculate all travel times
        double driverTimeToR1 = calculateTravelTime(driverLocation, r1, speed);
        double driverTimeToR2 = calculateTravelTime(driverLocation, r2, speed);
        double timeR1ToC1 = calculateTravelTime(r1, c1, speed);
        double timeR2ToC2 = calculateTravelTime(r2, c2, speed);
        double timeC1ToR2 = calculateTravelTime(c1, r2, speed);
        double timeC2ToR1 = calculateTravelTime(c2, r1, speed);

        // Calculate possible scenarios and find the shortest time
        double scenario1 = driverTimeToR1 + pt1 + timeR1ToC1 + timeC1ToR2 + pt2 + timeR2ToC2;
        double scenario2 = driverTimeToR2 + pt2 + timeR2ToC2 + timeC2ToR1 + pt1 + timeR1ToC1;

        return Math.min(scenario1, scenario2);
    }

    // Haversine formula to calculate travel time
    public double calculateTravelTime(double[] loc1, double[] loc2, double speed) {
        double R = 6371; // Earth's radius in km
        double latDiff = Math.toRadians(loc2[0] - loc1[0]);
        double lonDiff = Math.toRadians(loc2[1] - loc1[1]);
        double a = Math.sin(latDiff / 2) * Math.sin(latDiff / 2) +
                Math.cos(Math.toRadians(loc1[0])) * Math.cos(Math.toRadians(loc2[0])) *
                        Math.sin(lonDiff / 2) * Math.sin(lonDiff / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c; // Distance in km
        return (distance / speed) * 60; // Convert hours to minutes
    }
}
