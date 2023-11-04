/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment;

/**
 *
 * @author ADMIN
 */

import java.io.FileReader;
import java.util.*;
import java.lang.*;


public class CarManager {
    public static void main(String[] args) {
        BrandList brandList = new BrandList();
                 String filename = "C:\\Users\\ADMIN\\Desktop\\brands.txt";
                 
                Menu<String> menu = new Menu<>();
        ArrayList<String> options = new ArrayList<>();
        options.add("1- List all brands");
        options.add("2- Add a new brand");
        options.add("3- Search a brand based on its ID");
        options.add("4- Update a brand");
        options.add("5- Save brands to the file, named brands.txt");
        options.add("6- List all cars in ascending order of brand names");
        options.add("7- List cars based on a part of an input brand name");
        options.add("8- Add a car");
        options.add("9- Remov e a car based on its ID");
        options.add("10- Update a car based on its ID");
        options.add("11- Save cars to file, named cars.txt");
        int choice = menu.int_getChoice(options);
        System.out.println("Bạn đã chọn: " + options.get(choice - 1)); 

        
        switch (choice){
            case 1: 
        brandList.loadFromFile(filename);
               
                break;
            case 2: 
              brandList.saveToFile(filename);
                break;
            case 3:
                
                break;
                
            case 4:
            
                break;
        }
    
    }
}

