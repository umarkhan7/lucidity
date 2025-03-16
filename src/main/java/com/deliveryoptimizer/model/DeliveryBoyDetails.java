package com.deliveryoptimizer.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DeliveryBoyDetails {
    private String name;
    private double[] location;
    private double speed;
}
