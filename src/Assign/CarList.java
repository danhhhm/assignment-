/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assign;

/**
 *
 * @author Admin
 */
import Extend.Extensions;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.lang.*;

public class CarList extends ArrayList<Car> {
    private String carID, color, frameID, engineID;
    private Brand brand;
    Scanner sc = new Scanner(System.in);
    BrandList brandList;
    private ArrayList<String> carIDList = new ArrayList<>();
    private ArrayList<String> frameIDList = new ArrayList<>();
    


    public CarList( BrandList bList) {
        brandList = bList;
    }

    public boolean loadFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String[] arr;
            String line = br.readLine();
            while ((line != null)) {
                arr = line.split(",");
                carID = arr[0].trim();
                int index = brandList.searchID(arr[1].trim());
                if (index != - 1) {
                    brand = brandList.get(index);
                }
                color = arr[2].trim();
                frameID = arr[3].trim();
                engineID = arr[4].trim();
                this.add(new Car(carID, brand, color, frameID, engineID));
                carIDList.add(carID);
                frameIDList.add(frameID);
                line = br.readLine();
            }
            br.close();
            return true;
        } catch (IOException e) {
            System.out.println("File " + filename + " not found !");
        }
        return false;
    }

    public boolean saveToFile(String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Car car : this) {
                String line = car.getCarID() + ", " + car.getBrand().getBrandID() + ", " + car.getColor() + ", "
                        + car.getFrameID() + ", " + car.getEngineID();
                pw.println(line);
            }
            pw.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int searchID(String carID) {
        if (this.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < this.size(); i++) {
            if (carID.equals(this.get(i).getCarID())) {
                return i;
            }
        }
        return -1;
    }

    public int searchFrame(String fID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).equals(fID)) {
                return i;
            }
        }
        return -1;
    }

    public int searchEngine(String eID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).equals(eID)) {
                return i;
            }
        }
        return -1;
    }
    public void genRandomCar() {
        System.out.print("Enter number of cars you want to generate: ");
        Scanner sc = new Scanner(System.in);
        int numberOfGenerations = sc.nextInt();
        for (int i = 0; i < numberOfGenerations; i++) {
             carID = Extensions.genRandomCarID(carIDList);
             brand = brandList.get(Extensions.genRandomIntInRange(0, brandList.size() - 1));
             color = Extensions.genRandomColor();
             frameID = Extensions.genRandomFrameID(frameIDList);
             engineID = "E" + frameID.substring(1);
            this.add(new Car(carID, brand, color, frameID, engineID));
        }
        System.out.println(numberOfGenerations + " random car(s) has been generated");
    }

   public void addCar() { // hàm để thêm một chiếc xe vào danh sách xe - Dev By Bùi Quang Việt
//        for (int i = 0; i < 50; i++) {
//            carList.add(GeneratorInstant.generateRandomCar("C" + String.valueOf(i), listBrand));
//        }
        int index;
        String carID;
        while (true) {
            carID = Extensions.getID("Enter Car ID: ");
            index = searchID(carID);
            if (carID.equals("back")) {
                return;
            }
            if (index != -1) {
                System.out.println("Car with the same ID already exists!");
                System.out.println("Please try again! or input back to return MainMenu!");
            } else {
                break;
            }
        }

        Brand newBrand = brandList.getUserChoice();

         color = Extensions.getString("Enter color: ");
         frameID = Extensions.getID("Enter frameID: ");
         engineID = Extensions.getID("Enter engineID: ");
        Car newCar = new Car(carID, newBrand, color, frameID, engineID);
        this.add(newCar);
        System.out.println("Car added succesfully!.");
    }

    
    public void printBasedBrandName() { //hàm dùng để in ra các xe có tên thương hiệu chứa một chuỗi ký tự nhất định trong danh sách - Dev By Bùi Quang Việt
        String aPartOfBrandName = Extensions.getString("Enter brand name: ");
        int count =0;
        for(int i=0;i <this.size();i++) {
            Car car = this.get(i);
            if(car.getBrand().getBrandName().contains(aPartOfBrandName)) {
                System.out.println(this.get(i).screenString());
                count++;
            }
        }
        if(count == 0 ) {
            System.out.println("No car is detected.");
        }
    }
    public boolean removeCar() { //hàm dùng để xóa bỏ một chiếc xe khỏi danh sách - Dev By Bùi Quang Việt
        int pos;
        String removeID;
        removeID = Extensions.getString("Enter removeID: ");
        pos = searchID(removeID);
        if(pos >= 0) {
            this.remove(pos);
            System.out.println("Car has been removed successfully!");
            return true;
        }else{
            System.out.println("Not found!");
        }
        return false;
    }
    public void updateCar() { //hàm dùng đẻ cập nhật thông tin của một chiếc xe trong danh sách xe - Dev By Bùi Quang Việt
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
            Car car = new Car(updateID, newBrand, updateColor, updateFrameID, updateEngineID);
            this.set(pos, car);
            System.out.println("Car updated successfully!");
        }
    }
    public void listCars() { //hàm dùng đẻ liệt kê tất cả các xe trong danh sách xe - Dev By Bùi Quang Việt
        Collections.sort(this, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getBrand().getBrandName().compareToIgnoreCase(o2.getBrand().getBrandName());
            }
        });
        int i = 1;
        System.out.println(String.format("%-5s. || %-10s || %-15s || %-15s || %-15s || %-15s", "STT", "CarID", "BrandID", "Color", "FrameID", "EngineID"));
        for (Car c : this) {
            System.out.println(String.format("%-5s. || %-10s || %-15s || %-15s || %-15s || %-15s",
                    i, c.getCarID(), c.getBrand().getBrandID(), c.getColor(),  c.getFrameID(), c.getEngineID()   ));
            i++;
        }
    }
    
}
