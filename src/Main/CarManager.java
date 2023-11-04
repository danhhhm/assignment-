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

public class CarManager {

    public static void main(String[] args) {
        Menu menu = new Menu("Car Manager Application");
        boolean isrun = true;
        int choice;
        BrandList brandList = new BrandList();
        CarList carList = new CarList();
        Menu options = new Menu();
        options.addOptions("List all brands");
        options.addOptions("Add a new brand");
        options.addOptions("Search a brand based on its ID");
        options.addOptions("Update a brand");
        options.addOptions("Save brands to the file");
        options.addOptions("List all cars in ascending order of brand names");
        options.addOptions("List cars based on a part of an input brand name");
        options.addOptions("Add a car");
        options.addOptions("Remove a car based on its ID");
        options.addOptions("Update a car based on its ID");
        options.addOptions("Save cars to file, named cars.txt");
        options.addOptions("Load brand from file");
        options.addOptions("Load car from file");
        options.addOptions("Quit the program");
        do {
            menu.printMenu();
            choice = Menu.int_getChoice();
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
                    brandList.loadFromFile("E:\\JavaProject\\Assignment\\src\\assignment\\Brand.txt");
                    Extensions.getString("Press Enter to continue");
                    break;
                case 13:
                    carList.loadFromFile("E:\\JavaProject\\Assignment\\src\\assignment\\Cars.txt");
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
