/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import Extend.Extensions;
import Assign.BrandList;
import Assign.CarList;
import Assign.Menu;
import java.lang.*;
import java.util.*;
import java.math.*;
public class Main {

    public static void main(String[] args) {
        boolean run = true;
        int choice;
        BrandList brandList = new BrandList();
        CarList carList = new CarList(brandList);
        String[] options = {
            "List all brands",
            "Add a new brand",
            "Search a brand based on its ID",
            "Update a brand",
            "Save brands to the file",
            "Generate random Brands",
            "List all cars in ascending order of brand names",
            "List cars based on part of an input brand name",
            "Add a car",
            "Generate random Cars",
            "Remove a car based on its ID",
            "Update a car based on its ID",
            "Save cars to file, named cars.txt",
            "Quit the program"};

        do {
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                    brandList.listBrands();
                    Extensions.getString("Press Enter to continue");
                    break;
                case 2:
                    brandList.addBrand();
                    Extensions.getString("Press Enter to continue");
                    break;
                case 3:
                    brandList.searchBrand();
                    Extensions.getString("Press Enter to continue");
                    break;
                case 4:
                    brandList.updateBrand();
                    Extensions.getString("Press Enter to continue");
                    break;
                case 5:
                    brandList.saveToFile("Brand.txt");
                    Extensions.getString("Press Enter to continue");
                    break;    
                case 6:
                    brandList.genRandomBrand();
                    Extensions.getString("Press Enter to continue");
                    break;
                case 7:
                    carList.listCars();
                    Extensions.getString("Press Enter to continue");
                    break;
                case 8:
                    carList.printBasedBrandName();
                    Extensions.getString("Press Enter to continue");
                    break;
                case 9:
                    carList.addCar();
                    Extensions.getString("Press Enter to continue");
                    break;
                case 10:
                    carList.genRandomCar();
                    Extensions.getString("Press Enter to continue");
                    break;
                case 11:
                    carList.removeCar();
                    Extensions.getString("Press Enter to continue");
                    break;
                case 12:
                    carList.updateCar();
                    Extensions.getString("Press Enter to continue");
                    break;
                case 13:
                    carList.saveToFile("Cars.txt");
                    Extensions.getString("Press Enter to continue");
                    break;
                case 14:
                    run = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (run);
    }

}
