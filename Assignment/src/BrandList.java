/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class BrandList extends ArrayList<Brand> {

    private String brandID, brandName, soundBrand;
    private double price;
    private int pos;
    Scanner sc = new Scanner(System.in);
    PrintWriter pw;
    BufferedReader br;

    public boolean loadFromFIle(String fileName) throws Exception {
        try {
            br = new BufferedReader(new FileReader(fileName));
            String[] arr;
            String line = br.readLine();
            while (line != null) {
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
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " not found!");
        }
        return false;
    }

    //Open the file based on the filename to write data in line-by-line text format
    public boolean saveToFile(String fileName) {
        try {
            pw = new PrintWriter(new FileWriter(fileName));
            this.forEach((i) -> {
                pw.println(i);
            });
            pw.close();
            return true;
        } catch (IOException e) {
        }
        return false;
    }

    //Search a brand based on brand ID. Return the existence position
    public int searchID(String bID) {
        for (int i = 0; i < this.size(); i++) {
            if (bID.equals(this.get(i).getBrandID())) {
                return i;
            }
        }
        return -1;
    }

    //Transform the list to a menu, the user will choose a brand from this menu
    public Brand getUserChoice() {
        Menu menu = new Menu();
        return (Brand) menu.ref_getChoice(this);
    }

    //Add a new Brand to the list
    public void addBrand() {
        boolean checkBrandID = false;
        do {
            System.out.println("Input brand ID: ");
            brandID = sc.nextLine();
            for (int i = 0; i < this.size(); i++) {
                if (brandID.equals(this.get(i).getBrandID())) {
                    checkBrandID = true;
                    System.out.println("This ID existed. Try others!");
                    break;
                } else {
                    checkBrandID = false;
                }
            }
        } while (checkBrandID == true);

        do {
            System.out.println("Input brand name: ");
            brandName = sc.nextLine();
            if (brandName.equals("") != true) {
                break;
            }
            System.out.println("The brand name must not be null. Try again!");
        } while (true);

        do {
            System.out.println("Input sound brand: ");
            soundBrand = sc.nextLine();
            if (soundBrand.equals("") != true) {
                break;
            }
            System.out.println("The sound brand must not be null. Try again!");
        } while (true);

        do {
            System.out.println("Input price: ");
            try {
                price = Double.parseDouble(sc.nextLine());
                if (price < 0) {
                    System.out.println("The price must not be null. Try again!");
                }
            } catch (NumberFormatException e) {
                System.out.println("The price has to be a number. Try again!");
                price = 0;
            }
        } while (price == 0);
        this.add(new Brand(brandID, brandName, soundBrand, price));
        System.out.println("Brand added sucessfully");
    }

    //Update brand_name, sound_brand, price of an existed brand
    public void updateBrand() {
        do {
            System.out.println("Input brand ID: ");
            brandID = sc.nextLine();
            pos = searchID(brandID);
            if (pos != -1) {
                break;
            }
            System.out.println("Not found!");
        } while (true);
        do {
            System.out.println("Input brand name: ");
            brandName = sc.nextLine();
            if (brandName.equals("") != true) {
                break;
            }
            System.out.println("The brand name must not be null. Try again!");
        } while (true);

        do {
            System.out.println("Input sound brand: ");
            soundBrand = sc.nextLine();
            if (soundBrand.equals("") != true) {
                break;
            }
            System.out.println("The sound brand must not be null. Try again!");
        } while (true);

        do {
            System.out.println("Input price: ");
            try {
                price = Double.parseDouble(sc.nextLine());
                if (price < 0) {
                    System.out.println("The price must not be null. Try again!");
                }
            } catch (NumberFormatException e) {
                System.out.println("The price has to be a number. Try again!");
                price = 0;
            }
        } while (price == 0);
        this.get(0).setUpdateBrand(brandName, soundBrand, price);
        System.out.println("Brand has updated sucessfully");
    }

    public void listBrand(){
        this.forEach((i) -> {
            System.out.println(i);
        });
    }
}
