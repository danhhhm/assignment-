/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assign;

import Extend.Extensions;
//import java.awt.Menu;
import java.io.*;
import java.util.*;

public class BrandList extends ArrayList<Brand> {
    private String brandID, brandName, soundBrand;
    private double price;
    private Scanner sc = new Scanner(System.in);
    private ArrayList<String> brandIDList = new ArrayList<>();


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
                brandIDList.add(brandID);
                line = br.readLine();
            }
            br.close();
            return true;
        } catch (IOException e) {
            System.out.println("File " + filename + " not found !");
        }
        return false;
    }

    public boolean saveToFile(String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Brand brand : this) {
                String line = brand.getBrandID() + ", " + brand.getBrandName() + ", " + brand.getSoundBrand() + ": " + brand.getPrice();
                pw.println(line);
            }
            pw.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void genRandomBrand() {
        System.out.println("Enter the brand numbers you want to generate: ");
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            
             brandID = Extensions.genRandomBrandID(brandIDList);
             brandName = Extensions.genRandomBrandName();
             soundBrand = Extensions.genRandomSoundBrand();
             price = Extensions.getRound(Extensions.genRandomDoubleInRange(1.0, 10.0), "#.###");
            this.add(new Brand(brandID, brandName, soundBrand, price));
        }
        System.out.println(num + " brand(s) has been generated!");
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
        int i = 1;
        System.out.println(String.format("%-5s. || %-15s || %-20s || %-20s || %-10s", "STT", "BrandID", "BrandName", "SoundBrand", "Price"));
        for (Brand b : this) {
            System.out.println(String.format("%-5s. || %-15s || %-20s || %-20s || %-10s", i, b.getBrandID(), b.getBrandName(), b.getSoundBrand(), b.getPrice()));
            i++;
        }
        int choice = Extensions.getInt("Choose a new brand: ", 1, this.size());
        return this.get(choice - 1);
    }

    public void addBrand() {
        int pos;
        String brandID;
        do {
            brandID = Extensions.getID("Input brand ID: ");
            pos = searchID(brandID);
            if (pos >= 0) {
                System.out.println("This brand ID is existed. Try another one!");
            }
        } while (pos != -1);

         brandName = Extensions.getString("Input brand name: ");
         soundBrand = Extensions.getString("Input sound brand: ");
         price = Extensions.getPrice("Input price: ", 0, 100000);
        this.add(new Brand(brandID, brandName, soundBrand, price));

        System.out.println("Brand has been added successfully");
    }

    public void search() {
        List<Brand> matchingBrands = new ArrayList<>();
        System.out.println("Do you want to search for ID, name, sound, or price: ");
        String Choice = sc.next();
        if (Choice.equalsIgnoreCase("ID")) {
            String ID = Extensions.getString("Enter ID of brand you want to search: ");
            for (int i = 0; i < this.size(); i++) {
                if (this.get(i).getBrandID().equals(ID)) {
                    System.out.println("Found: " + this.get(i).toString());
                    return;
                }
            }
            System.out.println("Not found Brand with ID" + ID);
        } else if (Choice.equalsIgnoreCase("name")) {
            String name = Extensions.getString("Enter name of brand you want to search: ");
            for (int i = 0; i < this.size(); i++) {
                if (this.get(i).getBrandName().equals(name)) {
                    System.out.println("Found: " + this.get(i).toString());
                    return;
                }
            }

        } else if (Choice.equalsIgnoreCase("sound")) {
            String sound = Extensions.getString("Enter the sound of brand you want to search: ");
            for (int i = 0; i < this.size(); i++) {
                if (this.get(i).getSoundBrand().contains(sound)) {
                    matchingBrands.add(this.get(i));
                }
            }
            if (matchingBrands.isEmpty()) {
                System.out.println("No matching brands found.");
            } else {
                System.out.println("Found matching brands:");
                for (Brand matchingBrand : matchingBrands) {
                    System.out.println(matchingBrand.toString());
                }
            }
        } else if (Choice.equalsIgnoreCase("price")) {
            double minPrice = Extensions.getDouble("Enter the minimum price: ");
            double maxPrice = Extensions.getDouble("Enter the maximum price: ");
            for (int i = 0; i < this.size(); i++) {
                double price = this.get(i).getPrice();
                if (price >= minPrice && price <= maxPrice) {
                    matchingBrands.add(this.get(i));
                }
            }
            if (matchingBrands.isEmpty()) {
                System.out.println("No matching brands found.");
            } else {
                System.out.println("Found matching brands:");
                for (Brand matchingBrand : matchingBrands) {
                    System.out.println(matchingBrand.toString());
                }
            }
        }

    }

    

    public void updateBrand() {
        String brandID = Extensions.getString("Enter brand ID: ");
        int index = searchID(brandID);
        if (index == -1) {
            System.out.println("Not found brand ID!");
        } else {
             brandName = Extensions.getString("Enter brand name: ");
             soundBrand = Extensions.getString("Enter sound brand: ");
             price = Extensions.getPrice("Enter price: ", 0d, 100000000000d);
            Brand brand = new Brand(brandID, brandName, soundBrand, price);
            this.set(index, brand);
            System.out.println("Brand updated successfully!");
        }
    }
    

    public Brand getBrand(String brandID) {
        int pos = searchID(brandID);
        if (pos == -1) {
            return null;
        } else {
            return this.get(pos);
        }
    }

    public void listBrands() {
        int i = 1;
        System.out.println(String.format("%-5s. || %-15s || %-20s || %-20s || %-10s", "STT", "BrandID", "BrandName", "SoundBrand", "Price"));
        for (Brand b : this) {
            System.out.println(String.format("%-5s. || %-15s || %-20s || %-20s || %-10s", i, b.getBrandID(), b.getBrandName(), b.getSoundBrand(), b.getPrice()));
            i++;
        }
        System.out.println("Do you want to sort the brands?");
        System.out.println("Chose(ID/Price/No): ");
        String fieldChoice = sc.next();
        if (fieldChoice.equalsIgnoreCase("ID")) {
            Collections.sort(this, (b1, b2) -> b1.getBrandID().compareTo(b2.getBrandID()));
            //b1 b2 là đối tượng được generate từ random brand, b1.getBrandId là lấy id b1 so sánh với id b2
            //Dùng Collections.sort để sắp xếp danh sách trong Java là một cách tiện lợi. Nó  sắp xếp danh sách của bất kỳ đối tượng nào (các đối tượng triển khai giao diện Comparable hoặc cung cấp một Comparator riêng).
            //
        } else if (fieldChoice.equals("price")) {
            Collections.sort(this, (b1, b2) -> Double.compare(b1.getPrice(), b2.getPrice()));
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
            Collections.reverse(this);
            System.out.println("Brand has been sorted in decreasing order!");    
        } else System.out.println("Invalid choice for sorting order.");
    
    }

}
