package com.company;

public class SolarToyCar extends ToyCar implements SolarPanel{
    @Override
    public void chargeBattery(){
        System.out.println("Charging the car with solar energy using"+ numPanels+" solar panels");
        this.batteryLevel=fullBattery;
    }

    @Override
    public void moveWithSolarEnergy(double distance) {
        System.out.println("Moving forward for "+distance+"meters with solar energy only");
        System.out.println("Battery level is="+this.batteryLevel);

    }
    public void turnWithSolarEnergy(double angle) {
        System.out.println(" Turning for "+angle+"degrees with solar energy only");
        System.out.println("Battery level is="+this.batteryLevel);

    }
}
