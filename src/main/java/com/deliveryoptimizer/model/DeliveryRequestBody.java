package com.deliveryoptimizer.model;

import com.deliveryoptimizer.model.DeliveryBoyDetails;
import com.deliveryoptimizer.model.PreparationTimeDetails;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@Getter
@Setter
public class DeliveryRequestBody {

    private DeliveryBoyDetails deliveryBoy; // Delivery boy's details
    private double[] r1;             // [latitude, longitude]
    private double[] c1;             // [latitude, longitude]
    private double[] r2;             // [latitude, longitude]
    private double[] c2;             // [latitude, longitude]
    private PreparationTimeDetails preparationTime;


}
