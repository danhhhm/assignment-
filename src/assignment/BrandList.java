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
            String brandName = Extensions.genRandomBrandName();
            String soundBrand = Extensions.genRandomSoundBrand();
            double price = Extensions.genRandomPrice();
            
            Brand brand = new Brand(brandID, brandName, soundBrand, price);
            brandList.add(brand);
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
    while (true) {
        String brandID = Extensions.getString("Enter brand ID (or 'exit' to return to the main menu): ");

        if (brandID.equals("exit")) {
            System.out.println("Brand addition canceled.");
            break;
        }

        int pos = searchID(brandID);
        if (pos != -1) {
            System.out.println("This brand ID already exists. Try another one!");
        } else {
            String brandName = Extensions.getString("Enter brand name: ");
            String soundBrand = Extensions.getString("Enter sound brand: ");
            double price = Extensions.getPrice("Enter price: ", 0, 100000);

            if (price <= 0) {
                System.out.println("Price must be a positive number. Please try again.");
                continue;
            }

            // Create and add the new brand to the list
            Brand newBrand = new Brand(brandID, brandName, soundBrand, price);
            brandList.add(newBrand);
            System.out.println("Brand added successfully!");
            break;
        }
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
        
        System.out.println("Do you want to sort the brands?");
        System.out.println("Chose(ID/Price/No): ");
        String fieldChoice = sc.next();
        if (fieldChoice.equals("ID")) {
            Collections.sort(brandList, (b1, b2) -> b1.getBrandID().compareTo(b2.getBrandID()));
            //b1 b2 là đối tượng được generate từ random brand, b1.getBrandId là lấy id b1 so sánh với id b2
            //Dùng Collections.sort để sắp xếp danh sách trong Java là một cách tiện lợi. Nó  sắp xếp danh sách của bất kỳ đối tượng nào (các đối tượng triển khai giao diện Comparable hoặc cung cấp một Comparator riêng).
            //
        } else if (fieldChoice.equals("Price")) {
            Collections.sort(brandList, (b1, b2) -> Double.compare(b1.getPrice(), b2.getPrice()));
        } else if (fieldChoice.equals("no")) {
        System.out.println("Brands have not been sorted.");
        return;
        }
        else {
            System.out.println("Brand have not been sorted.");
            return;
        }  
    
        System.out.println("Do you want to sort in increasing or decreasing order?");
        System.out.println("Chose(inc/dec): ");
        String orderChoice = sc.next(); // Dòng này xóa bộ đệm (buffer) của Scanner.
        // "asc" (tăng dần) hoặc "desc" (giảm dần). 
        //orderChoice = scanner, nó sẽ đợi người dùng nhập một chuỗi từ bàn phím và sau đó trả về chuỗi đó. Chuỗi này sau đó được gán cho biến orderChoice
        if (orderChoice.equals("inc")) {
        System.out.println("Brand has been sorted in increasing order!");
        }
        else if (orderChoice.equals("dec")){
            Collections.reverse(brandList);
            System.out.println("Brand has been sorted in decreasing order!");    
        } else System.out.println("Invalid choice for sorting order.");
        
    
    }

}
