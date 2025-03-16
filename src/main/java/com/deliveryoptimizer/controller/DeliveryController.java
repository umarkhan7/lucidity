package com.deliveryoptimizer.controller;



import com.deliveryoptimizer.model.DeliveryBoyDetails;
import com.deliveryoptimizer.model.DeliveryRequestBody;
import com.deliveryoptimizer.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    @Autowired
    private RouteService routeService;

    @PostMapping("/shortest-time")
    public ResponseEntity<String> getShortestDeliveryTime(@RequestBody DeliveryRequestBody request) {
        try {
            String deliveryBoyName = request.getDeliveryBoy().getName();

            double shortestTime = routeService.calculateShortestRoute(
                    request.getDeliveryBoy().getLocation(),
                    request.getDeliveryBoy().getSpeed(),
                    request.getR1(),
                    request.getC1(),
                    request.getR2(),
                    request.getC2(),
                    request.getPreparationTime().getPt1(),
                    request.getPreparationTime().getPt2()

            );

            String response = "Shortest time to complete deliveries for " + deliveryBoyName + ": " + shortestTime + " minutes";
            return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (Exception e) {
        String errorMessage = "Error occurred while processing the request: " + e.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }
    @PostMapping("test")
    public String test(@RequestBody DeliveryBoyDetails req){
        System.out.println(req.getName() + " " + req.getLocation()[0]);
        return "printed";
    }
}
