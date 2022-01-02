package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        SolarToyCar tesla=new SolarToyCar();
        System.out.println(tesla.getBattery());
        tesla.forward(100.0);
        System.out.println(tesla.getBattery());
        tesla.turn(Direction.RIGHT,30.0);
        System.out.println(tesla.getBattery());
        tesla.chargeBattery();
        System.out.println(tesla.getBattery());
        tesla.moveWithSolarEnergy(100.0);
        System.out.println(tesla.getBattery());
        tesla.turnWithSolarEnergy(50.0);
        System.out.println(tesla.getBattery());

    }
}
