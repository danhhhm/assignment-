/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
package Assign;
import java.util.*;
import java.lang.*;
public class Car {

    private String carID;
    private Brand brand;
    private String color;
    private String frameID;
    private String engineID;

    public Car() {
    }

    public Car(String carID, Brand brand, String color, String frameID, String engineID) {
        this.carID = carID;
        this.brand = brand;
        this.color = color;
        this.frameID = frameID;
        this.engineID = engineID;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFrameID() {
        return frameID;
    }

    public void setFrameID(String frameID) {
        this.frameID = frameID;
    }

    public String getEngineID() {
        return engineID;
    }

    public void setEngineID(String engineID) {
        this.engineID = engineID;
    }

    @Override
    public String toString() {
        return  "carID: " + carID + ", brand: " + brand.brandID + ", color: " + color + ", frameID: " + frameID + ", engineID: " + engineID + '}';
    }
    public int comparedTo(Car car) {
        int d = this.brand.getBrandName().compareTo(car.brand.getBrandName());
        if (d!=0) 
            return 0;
        return this.carID.compareTo(car.carID);
    }
    
    public String screenString() {
        return "brand: " +brand+ "\n" +"carID: " + carID+ ", color: " +color+ ", frameID: " +frameID+", engineID: " +engineID;
    }
    
}
