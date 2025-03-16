package com.deliveryoptimizer;

import com.deliveryoptimizer.model.DeliveryBoyDetails;

public class TestMain {
    public static void main(String[] args) {
        System.out.println("Hi Juist Checking");
        DeliveryBoyDetails boy = new DeliveryBoyDetails();
        double[] loc = {1111.22,2222.22};
        boy.setName("Name");
        boy.setLocation(loc);

        System.out.println("Printing the set elements");
        System.out.println(boy.getName());
        System.out.println(boy.getLocation()[0] + " " + boy.getLocation()[1]);



    }
}
