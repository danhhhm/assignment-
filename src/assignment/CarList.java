/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author Admin
 */
import Extend.Extensions;
import Extend.FileIO;
import java.util.*;
import java.lang.*;

public class CarList {

    private ArrayList<Car> carList;
    BrandList brandList;

    public CarList(ArrayList<Car> carList, BrandList bList) {
        this.carList = carList;
        this.brandList = bList;
    }

    public boolean saveToFile(String filename) {

        try {
            FileIO.writeFile(filename, "");
            for (int i = 0; i < carList.size(); i++) {
                String carInf = carList.get(i).getCarID() + "|" + carList.get(i).getBrand() + "|"
                        + carList.get(i).getColor() + "|" + carList.get(i).getFrameID() + "|"
                        + carList.get(i).getEngineID() + "\n";
                FileIO.appendFile(filename, carInf);
            }
            System.out.println("Save to File successfully!");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean loadFromFile(String filename) {
        try {
            String Inf = FileIO.readFile(filename);
        String arr[] = Inf.split("\n");
        carList.removeAll(carList);
        for (int i = 0; i < arr.length; i++) {
            String[] carInf = arr[i].split("|");
            Brand brand = brandList.getBrand(carInf[1]);
            if (brand == null) {
                System.err.println("Err can't load from file! Brand not found");
                return false;
            }

            Car car = new Car(carInf[0], brand, carInf[2], carInf[3], carInf[4].trim());
            carList.add(car);

        }
        System.out.println("Load from file successfully!");
        return true;
        } catch (Exception e) {
            System.err.println("File: " + filename + " not found!");
        }
        return false;
    }

    public int searchID(String carID) {
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getCarID().equals(carID)) {
                return i;
            }
        }
        return -1;
    }

    public int searchFrame(String fID) {
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).equals(fID)) {
                return i;
            }
        }
        return -1;
    }

    public int searchEngine(String eID) {
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).equals(eID)) {
                return i;
            }
        }
        return -1;
    }

    public void addCar() {
        int pos;
        String carID,engineID,frameID;
        do {
            carID = Extensions.getID("Enter car ID: ");
            pos = searchID(carID);
            if(pos >= 0) {
                System.out.println("This car ID is  existed. Try another one!");
            }
        } while(pos != -1);
        
        Brand brand = menu.ref_getChoice(brandList);
        String color = Extensions.getID("Enter color: ");
        do {
             frameID = Extensions.getID("Enter framID: ");
            pos = searchFrame(frameID);
            if(pos >=0) {
                System.out.println("This frame ID is existed. Try another one!");
            }
        } while(pos != -1);
        do {
             engineID = Extensions.getID("Input engine ID: ");
            pos = searchEngine(engineID);
            if (pos >= 0) {
                System.out.println("This engine ID is existed. Try another one!");
            }
        } while (pos != -1);
        carList.add(new Car(carID, brand, color, frameID, engineID));
        System.out.println("Car has been added successfully!");
    }
    
    public void printBasedBrandName() {
        
    }
}
