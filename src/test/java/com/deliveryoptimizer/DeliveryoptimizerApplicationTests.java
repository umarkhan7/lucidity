package com.deliveryoptimizer;

import com.deliveryoptimizer.service.RouteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DeliveryoptimizerApplicationTests {

	private RouteService routeService;

	@BeforeEach
	void setUp() {
		routeService = new RouteService();
	}

	@Test
	void testCalculateTravelTime() {
		// Given
		double[] location1 = {12.9352, 77.6245}; // Example geo-coordinates
		double[] location2 = {12.9362, 77.6240};
		double speed = 20.0; // Speed in km/h

		// When
		double travelTime = routeService.calculateTravelTime(location1, location2, speed);

		// Then
		assertTrue(travelTime > 0, "Travel time should be greater than 0");
	}

	@Test
	void testCalculateShortestRouteScenario1() {
		// Given
		double[] deliveryBoyLocation = {12.9352, 77.6245};
		double[] r1 = {12.9362, 77.6240};
		double[] c1 = {12.9372, 77.6235};
		double[] r2 = {12.9382, 77.6230};
		double[] c2 = {12.9392, 77.6225};
		double pt1 = 10; // Preparation time in minutes
		double pt2 = 15; // Preparation time in minutes
		double speed = 20.0; // Speed in km/h

		// When
		double shortestTime = routeService.calculateShortestRoute(deliveryBoyLocation, speed, r1, c1, r2, c2, pt1, pt2);

		// Then
		assertTrue(shortestTime > 0, "Shortest delivery time should be greater than 0");
	}

	@Test
	void testCalculateShortestRouteScenario2() {
		// Given
		double[] deliveryBoyLocation = {12.9352, 77.6245};
		double[] r1 = {12.9362, 77.6240};
		double[] c1 = {12.9372, 77.6235};
		double[] r2 = {12.9382, 77.6230};
		double[] c2 = {12.9392, 77.6225};
		double pt1 = 5;  // Preparation time in minutes
		double pt2 = 20; // Preparation time in minutes
		double speed = 20.0; // Speed in km/h

		// When
		double shortestTime = routeService.calculateShortestRoute(deliveryBoyLocation,speed,r1, c1, r2, c2, pt1, pt2);

		// Then
		assertNotNull(shortestTime, "Shortest delivery time should not be null");
		assertTrue(shortestTime > 0, "Shortest delivery time should be greater than 0");
	}

}
