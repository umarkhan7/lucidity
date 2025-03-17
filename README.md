# Lucidity
Senior Backend Engineer Assesment
# Delivery Optimization Using the Haversine Formula

This project provides a solution for optimizing delivery routes using the **Haversine formula** to calculate travel times between geo-coordinates. It calculates the shortest delivery time for a delivery boy assigned to pick up orders from two restaurants and deliver them to two consumers.

---

## Problem Overview

The task involves:
1. Calculating travel times between geo-locations (delivery boy, restaurants, and consumers).
2. Considering preparation times for restaurants.
3. Evaluating all possible routes.
4. Finding the shortest delivery time.

---

## The Haversine Formula

The **Haversine formula** calculates the great-circle distance between two points on the Earth’s surface using their latitude and longitude.
It is derived from the haversine function in spherical trigonometry. It calculates the great-circle distance between two points on a sphere (like Earth), which is crucial for geographical applications.

### Formula
Convert latitude and longitude differences to radians:

Use the Haversine formula:

$$a = \sin^2\left(\frac{\Delta \text{lat}}{2}\right) + \cos(\text{lat}_1) \cdot \cos(\text{lat}_2) \cdot \sin^2\left(\frac{\Delta \text{lon}}{2}\right)$$ $$c = 2 \cdot \arctan2(\sqrt{a}, \sqrt{1 - a})$$

Calculate distance:

$$\text{distance} = R \cdot c$$



Where
𝑅
 is the Earth's radius (6,371 km
).

Convert to travel time:

$$\text{travel time (minutes)} = \frac{\text{distance (km)}}{\text{speed (km/h)}} \cdot 60$$


Reference: [Haversine Formula - Wikipedia](https://en.wikipedia.org/wiki/Haversine_formula)

<!-- ### Formula Steps:
1. Compute differences in latitude and longitude (in radians):
\[
   \Delta \text{latitude} = \text{latitude}_2 - \text{latitude}_1
   \]


   

\[
   \Delta \text{longitude} = \text{longitude}_2 - \text{longitude}_1
   \]



2. Apply the Haversine formula:
   

\[
   a = \sin^2\left(\frac{\Delta \text{latitude}}{2}\right) + 
       \cos(\text{latitude}_1) \cdot \cos(\text{latitude}_2) \cdot 
       \sin^2\left(\frac{\Delta \text{longitude}}{2}\right)
   \]


   

\[
   c = 2 \cdot \arctan2\left(\sqrt{a}, \sqrt{1 - a}\right)
   \]



3. Compute the distance \(d\):
   

\[
   d = R \cdot c
   \]


   Where \(R\) is the Earth's radius (\(6,371 \, \text{km}\)).

4. Convert distance to travel time:
   

\[
   \text{Travel Time (minutes)} = \frac{d}{\text{Speed (km/h)}} \cdot 60
   \]


-->
---

## Solution Workflow

1. **Inputs:**
   - Geo-coordinates of:
     - Delivery Boy.
     - Two Restaurants (R1, R2).
     - Two Consumers (C1, C2).
   - Restaurant preparation times (`pt1` and `pt2`).
   - Average travel speed (20 km/h).

2. **Outputs:**
   - Shortest delivery time for completing all deliveries.

3. **Implementation Steps:**
   - Use the Haversine formula to calculate travel times between all points.
   - Add preparation times at restaurants.
   - Evaluate all possible routes to find the shortest one.

---

## Code Implementation
<!--
### Haversine Formula in Java
```java
public static double calculateTravelTime(double[] loc1, double[] loc2, double speed) {
    double R = 6371; // Earth's radius in km

    // Calculate latitude and longitude differences
    double latDiff = Math.toRadians(loc2[0] - loc1[0]);
    double lonDiff = Math.toRadians(loc2[1] - loc1[1]);

    // Apply Haversine formula
    double a = Math.pow(Math.sin(latDiff / 2), 2) +
               Math.cos(Math.toRadians(loc1[0])) *
               Math.cos(Math.toRadians(loc2[0])) *
               Math.pow(Math.sin(lonDiff / 2), 2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

    // Compute distance
    double distance = R * c;

    // Convert to travel time in minutes
    return (distance / speed) * 60;
}

```-->
### HOW TO RUN THE CODE
1. gitclone the master brach- deliveryoptimizer service.
2. Paste the below curl in the postman [CLICK HERE](#curl)
```json
{
  "deliveryBoy": {
    "name": "Aman",
    "location": [12.9352, 77.6245],
    "speed":"20.0"
  },
  "r1": [12.9362, 77.6240],
  "c1": [12.9372, 77.6235],
  "r2": [12.9382, 77.6230],
  "c2": [12.9392, 77.6225],
  "preparationTime": {
    "pt1": 10,
    "pt2": 15
  }
}

```


<a name = "curl"></a>
```CURL
curl --location 'http://localhost:8080/delivery/shortest-time' \
--header 'Content-Type: application/json' \
--data '{
  "deliveryBoy": {
    "name": "Aman",
    "location": [12.9352, 77.6245],
    "speed":"20.0"
  },
  "r1": [12.9362, 77.6240],
  "c1": [12.9372, 77.6235],
  "r2": [12.9382, 77.6230],
  "c2": [12.9392, 77.6225],
  "preparationTime": {
    "pt1": 10,
    "pt2": 15
  }
}
'
```
