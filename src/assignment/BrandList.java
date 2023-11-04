/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import Extend.Extensions;
import Extend.FileIO;
//import java.awt.Menu;
import java.io.*;
import java.util.*;

public class BrandList extends ArrayList<Brand> {

    private ArrayList<Brand> brandList;
    private Scanner sc = new Scanner(System.in);

    public BrandList() {
        brandList = new ArrayList<Brand>();
    }

    public void loadFromFile(String filename) {
        String data = FileIO.readFile(filename);
        String[] arr = data.split("\n");
        brandList.removeAll(brandList);
        for (int i = 0; i < arr.length; i++) {
            String[] brandData = arr[i].split("\\|");
            brandList.add(new Brand(brandData[0], brandData[1], brandData[2], Double.valueOf(brandData[3])));
        }
    }

    public boolean saveToFile(String filename) {
        boolean result = false;
        FileIO.writeFile(filename, "");
        for (int i = 0; i < brandList.size(); i++) {
            String s = brandList.get(i).getBrandID() + "|" + brandList.get(i).getBrandName()
                    + "|" + brandList.get(i).getSoundBrand() + "|" + brandList.get(i).getPrice() + "\n";
            result = FileIO.appendFile(filename, s);
        }
        return result;
    }

    public void genRandomBrand() {
        System.out.println("Enter the brand numbers you want to generate: ");
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            String brandID = Extensions.genRandomBrandID();
            String branName = Extensions.genRandombranName();
            String soundBrand = Extensions.genRandomsoundBrand();
            double price = Extensions.genRandomPrice();
        }
        System.out.println(num + " brand(s) has been generated!");
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
        int i = 1;
        System.out.println(String.format("%-5s. || %-15s || %-40s || %-20s || %-10s", "STT", "BrandID", "BrandName", "SoundBrand", "Price"));
        for (Brand b : brandList) {
            System.out.println(String.format("%-5s. || %-15s || %-40s || %-20s || %-10s", i, b.getBrandID(), b.getBrandName(), b.getSoundBrand(), b.getPrice()));
            i++;
        }
        int choice = Extensions.getInt("Choose a new brand: ", 1, brandList.size());
        return brandList.get(choice - 1);
    }

    public void addBrand() {
        String brandID;
        int pos;
        do {
            brandID = Extensions.getString("Enter brand ID: ");
            pos = searchID(brandID);
            if (brandID.equals("exit")) {
                if (pos == -1) {
                    System.out.println("This brand ID is existed. Try another one!");
                    System.out.println("Please try again! or input exit to return MainMenu!");
                } else {
                    break;
                }
            }

        } while (true);

        String brandName = Extensions.getString("Input brand name: ");
        String soundBrand = Extensions.getString("Input sound brand: ");
        double price = Extensions.getPrice("Input price: ", 0, 100000);
        brandList.add(new Brand(brandID, brandName, soundBrand, price));

        System.out.println("Brand has been added successfully");
    }

    public void searchBrand() {
        String ID = Extensions.getString("Enter ID of brand you want to search: ");
        for (int i = 0; i < brandList.size(); i++) {
            if (brandList.get(i).getBrandID().equals(ID)) {
                System.out.println("Found: " + brandList.get(i).toString());
                return;
            }
        }
        System.out.println("Not found Brand with ID" + ID);
    }

    public void updateBrand() {
        Menu menu = new Menu("Chose thing(s) you want to update: ");
        menu.addOptions("1. Update BrandName.");
        menu.addOptions("2. Update SoundBrand.");
        menu.addOptions("3. Update Price.");
        menu.addOptions("4. Update All.");
        menu.addOptions("5. Exit");
        int choice = 0;
        String yes = "Y";
        String brandID = Extensions.getID("Input brandID: ");
        int pos = searchID(brandID);
        if (pos == -1) {
            System.out.println("Not found");
        } else {
            do {
                Brand set = this.get(pos);
                System.out.println("Brand before update: ");
                System.out.println(set);
                menu.int_getChoice();
                switch (choice) {
                    case 1:
                        String brandName = Extensions.getString("Input brand name: ");
                        set.setBrandName(brandName);
                        System.out.println("Brand name has been updated successfully !");
                        System.out.println("Do you want to continue updating?");
                        System.out.print("Choose(Y/N): ");
                        yes = sc.nextLine().toUpperCase();
                        if (!yes.equals("Y")) {
                            yes = "N";
                        }
                    case 2:
                        String soundBrand = Extensions.getString("Input sound brand: ");
                        set.setSoundBrand(soundBrand);
                        System.out.println("Sound brand has been updated successfully !");
                        System.out.println("Do you want to continue updating?");
                        System.out.print("Choose(Y/N): ");
                        yes = sc.nextLine().toUpperCase();
                        if (!yes.equals("Y")) {
                            yes = "N";
                        }
                    case 3:
                        double price = Extensions.getPrice("Input price: ", 0D, 100000000000D);
                        set.setPrice(price);
                        System.out.println("Brand's price has been updated successfully !");
                        System.out.println("Do you want to continue updating?");
                        System.out.print("Choose(Y/N): ");
                        yes = sc.nextLine().toUpperCase();
                        if (!yes.equals("Y")) {
                            yes = "N";
                        }
                    case 4:
                        brandName = Extensions.getString("Input brand name: ");
                        soundBrand = Extensions.getString("Input sound brand: ");
                        price = Extensions.getPrice("Input price: ", 0D, 100000000000D);
                        set.setBrandName(brandName);
                        set.setSoundBrand(soundBrand);
                        set.setPrice(price);
                        System.out.println("Brand has been updated successfully !");
                        System.out.println("Do you want to continue updating?");
                        System.out.print("Choose(Y/N): ");
                        yes = sc.nextLine().toUpperCase();
                        if (!yes.equals("Y")) {
                            yes = "N";
                        }
                        break;
                }
            } while (choice >= 1 && choice <= 4 && yes.equals("Y"));

        }

    }

    public Brand getBrand(String brandID) {
        int pos = searchID(brandID);
        if (pos == -1) {
            return null;
        } else {
            return brandList.get(pos);
        }
    }

    public void listBrands() {
        int i = 1;
        System.out.println(String.format("%-5s. || %-15s || %-40s || %-20s || %-10s", "STT", "BrandID", "BrandName", "SoundBrand", "Price"));
        for (Brand b : brandList) {
            System.out.println(String.format("%-5s. || %-15s || %-40s || %-20s || %-10s", i, b.getBrandID(), b.getBrandName(), b.getSoundBrand(), b.getPrice()));
            i++;
        }
    }

}
