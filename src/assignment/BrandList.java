/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment;

import Extend.Extensions;
import java.io.*;
import java.util.*;

public class BrandList extends ArrayList<Brand> {

    private String brandID, brandName, soundBrand;
    private double price;
    private Scanner sc = new Scanner(System.in);

    public BrandList() {
    }

    public boolean loadFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String[] arr;
            String line = br.readLine();
            while ((line != null)) {
                arr = line.split(",");
                brandID = arr[0].trim();
                brandName = arr[1].trim();
                soundBrand = arr[2].split(":")[0].trim();
                price = Double.parseDouble(arr[2].split(":")[1].trim());
                this.add(new Brand(brandID, brandName, soundBrand, price));
                line = br.readLine();
            }
            br.close();
            return true;
        } catch (IOException e) {
            System.out.println("File " + filename + " not found !");
        }
        return false;
    }

    public boolean saveToFile(String fileName) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(fileName));
            for (Brand i : this) {
                pw.println(i);
            }
            pw.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int searchID(String bID) {
        for (int i = 0; i < this.size(); i++) {
            if (bID.equals(this.get(i).getBrandID())) {
                return i;
            }
        }
        return -1;
    }

    public Brand getUserChoice() {
        Menu mnu = new Menu();
        return (Brand) mnu.ref_getChoice(this);
    }

    public void addBrand() {
        boolean checkBrandID = false;
        do {
            System.out.println("Input brand ID: ");
            brandID = sc.nextLine();
            for(int i=0;i<this.size();i++){
                if(brandID.equals(this.get(i).getBrandID())) {
                    checkBrandID = true;
                    System.out.println("This brand ID is existed. Try another one!");
                    break;
                } else {
                    checkBrandID=false;
                }
            }
        } while(checkBrandID == true);
        
        brandName = Extensions.getString("Input brand name: ");
        soundBrand = Extensions.getString("Input sound brand: ");
        price = Extensions.getPrice("Input price: ", 0, 100000);
        this.add(new Brand(brandID, brandName, soundBrand, price));
        
        System.out.println("Brand has been added successfully");
    }
    public void updateBrand() {
        brandID = Extensions.getID("Input brandID: ");
        int pos = searchID(brandID);
        if(pos == -1 ) {
            System.out.println("Not found");
        } else {
            brandName = Extensions.getString("Input brand name: ");
            soundBrand = Extensions.getString("Input sound brand: ");
            price = Extensions.getPrice("Input price: ", 0D, 100000000000D);
            Brand brand = new Brand(brandID, brandName, soundBrand, price);
            this.add(pos, brand);
            System.out.println("Brand updated successfully!");
        }
        
    }
    

}