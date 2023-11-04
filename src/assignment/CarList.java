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

    public CarList() {
    }

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
         while (true) {
            carID = Extensions.getString("Enter Car ID: ");
            pos = searchID(carID);
            if (carID.equals("exit")) {
                return;
            }
            if (pos != -1) {
                System.out.println("Car  ID already exists!");
                System.out.println("Please try again! or enter exit to return MainMenu!");
            } else {
                break;
            }
        }
        Brand newBrand = brandList.getUserChoice();
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
        carList.add(new Car(carID, newBrand, color, frameID, engineID));
        System.out.println("Car has been added successfully!");
    }
    
    public void printBasedBrandName() {
        String aPartOfBrandName = Extensions.getString("Enter brand name: ");
        int count =0;
        for(int i=0;i <carList.size();i++) {
            Car car = carList.get(i);
            if(car.getBrand().getBrandID().contains(aPartOfBrandName)) {
                System.out.println(car);
                count++;
            }
        }
        if(count == 0 ) {
            System.out.println("No car is detected.");
        }
    }
    public boolean removeCar() {
        int pos;
        String removeID;
        removeID = Extensions.getString("Enter removeID: ");
        pos = searchID(removeID);
        if(pos >= 0) {
            carList.remove(pos);
            System.out.println("Car has been removed successfully!");
            return true;
        }else{
            System.out.println("Not found!");
        }
        return false;
    }
    public void updateCar() {
        String updateID = Extensions.getString("Enter ID you need to update: ");
        int pos = searchID(updateID);
        if(pos <0) {
            System.out.println("CarID: " +updateID+" is not found!");
        } else {
            Brand newBrand = brandList.getUserChoice();
            String newBrandID = newBrand.getBrandID();
            String updateColor = Extensions.getString("Enter new color: ");
            String updateFrameID = Extensions.getString("Enter new frameID: ");
            String updateEngineID = Extensions.getString("Enter new engineID: ");
            Car car = new Car(updateID, newBrand, updateColor, updateID, updateID);
            carList.set(pos, car);
            System.out.println("Car updated successfully!");
        }
    }
    public void listCars() {
        Collections.sort(carList, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o2.getBrand().getBrandName().compareToIgnoreCase(o1.getBrand().getBrandName());
            }
        });
        int i = 1;
        System.out.println(String.format("%-5s. || %-10s || %-15s || %-15s || %-15s || %-15s", "STT", "CarID", "BrandID", "Color", "FrameID", "EngineID"));
        for (Car c : carList) {
            System.out.println(String.format("%-5s. || %-10s || %-15s || %-15s || %-15s || %-15s",
                    i, c.getCarID(), c.getBrand().getBrandID(), c.getColor(),  c.getFrameID(), c.getEngineID()   ));
            i++;
        }
    }

    public void listCarsByBrand() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
