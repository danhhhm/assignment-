/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import Extend.Extensions;
import assignment.BrandList;
import assignment.CarList;
import assignment.Menu;
import java.lang.*;
import java.util.*;
import java.math.*;
public class Assignment {

    public static void main(String[] args) {
        boolean isrun = true;
        int choice;
        BrandList brandList = new BrandList();
        CarList carList = new CarList();
        String[] options = {
            "List all brands",
            "Add a new brand",
            "Search a brand based on its ID",
            "Update a brand",
            "Save brands to the file",
            "List all cars in ascending order of brand names",
            "List cars based on a part of an input brand name",
            "Add a car",
            "Remove a car based on its ID",
            "Update a car based on its ID",
            "Save cars to file, named cars.txt",
            "Load brand from file",
            "Load car from file",
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
                    carList.listCars();
                    Extensions.getString("Press Enter to continue");
                    break;
                case 7:
                    carList.listCarsByBrand();
                    Extensions.getString("Press Enter to continue");
                    break;
                case 8:
                    carList.addCar();
                    Extensions.getString("Press Enter to continue");
                    break;
                case 9:
                    carList.removeCar();
                    Extensions.getString("Press Enter to continue");
                    break;
                case 10:
                    carList.updateCar();
                    Extensions.getString("Press Enter to continue");
                    break;
                case 11:
                    carList.saveToFile("Cars.txt");
                    Extensions.getString("Press Enter to continue");
                    break;
                case 12:
                    brandList.loadFromFile("Brand.txt");
                    Extensions.getString("Press Enter to continue");
                    break;
                case 13:
                    carList.loadFromFile("Cars.txt");
                    Extensions.getString("Press Enter to continue");
                    break;
                case 14:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (isrun);
    }

}
