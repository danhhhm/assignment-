/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment;

import Extend.Extensions;
import Extend.FileIO;
import java.awt.Menu;
import java.io.*;
import java.util.*;

public class BrandList {

    private ArrayList<Brand> brandList;
    

    public BrandList() {
        brandList = new ArrayList<Brand>();
    }

    public void loadFromFile(String filename) {
        String data = FileIO.readFile(filename);
        String[] arr = data.split("\n");
        brandList.removeAll(brandList);
        for(int i=0;i <arr.length;i++) {
            String[] brandData = arr[i].split("\\|");
            brandList.add(new Brand(brandData[0], brandData[1], brandData[2], Double.valueOf(brandData[3])));
        }
    }
    

    public boolean saveToFile(String filename) {
        boolean result = false;
        FileIO.writeFile(filename, "");
        for(int i=0;i<brandList.size();i++) {
            String s = brandList.get(i).getBrandID() + "|" + brandList.get(i).getBrandName()
                    + "|" +brandList.get(i).getSoundBrand() + "|" + brandList.get(i).getPrice() + "\n";
            result = FileIO.appendFile(filename, s);
        }
        return result;
    }

    public int searchID(String bID) {
        for (int i = 0; i < brandList.size(); i++) {
            if (bID.equals(brandList.get(i).getBrandID().equals(bID))) {
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
        String brandID = Extensions.getString("Enter brand ID: ");
        int pos = searchID(brandID);
        do {
            System.out.println("Input brand ID: ");
            for(int i=0;i<this.size();i++){
                if(brandID.equals(this.get(i).getBrandID())) {
                    pos = true;
                    System.out.println("This brand ID is existed. Try another one!");
                    break;
                } else {
                    pos=false;
                }
            }
        } while(pos == true);
        
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