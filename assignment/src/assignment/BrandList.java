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

import java.util.*;
import java.lang.String;
import java.util.ArrayList;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;


public class BrandList extends ArrayList<Brand> {
    
    private ArrayList<Brand> brandList;

    public BrandList() {
        this.brandList = new ArrayList <>();
    }
    
 public boolean loadFromFile(String filename) {
   try {
            File file = new File(filename);
            if (!file.exists()) {
                System.out.println("File does not exist.");
                return false;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String brandID = parts[0];
                    String brandName = parts[1];
                    String soundBrand = parts[2];
                    double price = Double.parseDouble(parts[3]);
                    Brand brand = new Brand(brandID, brandName, soundBrand, price);
                    brandList.add(brand);
                }
                System.out.println(line);
            }

            reader.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("failed to load!!!");
            return false;
        }
    }


        
        /* try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}*/
    
    
   

// Check if a brand with the same ID already exists in the list
private boolean IDExists(String ID) {
    for (Brand brand : brandList) {
        if (brand.getBrandID().equals(ID)) {
            return true; // ID already exists
        }
    }
    return false; // ID is unique //To change body of generated methods, choose Tools | Templates.
    }

    
    public boolean saveToFile(String brand) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(brand))) {
            for (Brand br : brandList) {
                writer.write(br.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            return false;
        }

        return true;
    }
    
    
    public int searchID (String bID){
        int N= 100000000;
                for (int i=0; i<N-1;i++){
                    if (brandList.get(i).getBrandID().equals(bID)){
                     return i;
                    }
                }
        return -1;
    }
    
    public Brand getUserChoice(){
        Menu mnu = new Menu();
            return (Brand)mnu.ref_getChoice(brandList);      
    }
    
 private void addBrand(String brandID, String brandName, String soundBrand, double price) {
        if (IDExists(brandID)) {
        System.out.println("Brand with the same ID already exists.");
        return; // Exit the method
    }

    if (brandName.isEmpty()) {
        System.out.println("Brand name cannot be blank.");
        return; // Exit the method
    }

    if (soundBrand.isEmpty()) {
        System.out.println("Sound brand cannot be blank.");
        return; // Exit the method
    }

    if (price <= 0) {
        System.out.println("Price must be greater than 0.");
        return; // Exit the method
    }

    // Create a new brand from input data (replace Brand with your actual class name)
    Brand Brand = new Brand(brandID, brandName, soundBrand, price);

    // Add the new brand to the list (assuming brandsList is a List<Brand>)
    brandList.add(Brand);
}
 
 public void updateBrand(String brandID, String brandName, String soundBrand, double price){
        
    int pos = searchID(brandID);
    if (pos < 0) {
        System.out.println("not found!");
        
 } else {
         Brand brand = brandList.get(pos);
            brand.setBrandName(brandName);
            brand.setSoundBrand(soundBrand);
            brand.setPrice(price);
         }
    
 }
    
}

 