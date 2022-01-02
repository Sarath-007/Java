// Vehicle insurance
package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        System.out.println("Enter your vehicle type:");
        System.out.println("Car,Bus,Truck,Motorcycle");
        Scanner sc=new Scanner(System.in);
        String type=sc.nextLine();
        int premium=0;
        switch(type){
            case "Car":
                premium=200;
                break;
            case "Bus":
                premium=300;
                break;
            case "Truck":
                premium=400;
                break;
            case "Motorcycle":
                System.out.println("Enter your motorcycle type");
                System.out.println("1(low power), 2(medium power),3(high power) ");
                String moto=sc.nextLine();
                int motoType=Integer.parseInt(moto);
                switch(motoType){
                    case 1:
                        premium=200;
                        break;
                    case 2:
                        premium=300;
                        break;
                    case 3:
                        premium=400;
                        break;
                    default:
                        System.out.println("Unknown moto type");
                }
                break;
            default:
                System.out.println("Unknown vehicle type");
        }
        sc.close();
        System.out.println("The premium is Rs "+ premium);


    }
}
