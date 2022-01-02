package com.company;

public class ToyCar {
    protected double batteryLevel;
    protected final double fullBattery=1000;
    public ToyCar(){
        batteryLevel=fullBattery;
    }
    public void forward(double distance){
        System.out.println("Moving forward for"+distance+"meters");
        batteryLevel-=distance;
    }
    public void turn(Direction dir,double angle){
        System.out.println("Turning the car to "+ dir + "by "+angle+"degrees");
        batteryLevel-=angle;
    }
    public double getBattery(){
        return batteryLevel;
    }
    public void chargeBattery(){
        System.out.println("Charging the car through wall socket");
        batteryLevel=fullBattery;
    }
}
