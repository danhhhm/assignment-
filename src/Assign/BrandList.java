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
    
    //load file nội dung có sẵn - Dev by QuocDat
    public boolean loadFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String[] arr;
            String line = br.readLine(); 
            while ((line != null)) { //nếu không phải khoảng trắng thì thực hiện vòng lặp
                arr = line.split(","); 
                brandID = arr[0].trim(); //vị trí đầu để brandID xóa đi khoảng trắng
                brandName = arr[1].trim();
                soundBrand = arr[2].split(":")[0].trim(); //vị trí 3 sau khi split và xóa khoảng trắng ở vị trí đầu
                price = Double.parseDouble(arr[2].split(":")[1].trim());//ép kiểu về double 
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

    //save nội dung đã đổi vào file gốc - Dev by QuocDat
    public boolean saveToFile(String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Brand brand : this) { //duyệt cả file 
                String line = brand.getBrandID() + ", " + brand.getBrandName() + ", " + brand.getSoundBrand() + ": " + brand.getPrice();
                pw.println(line); //in vào file 
            }
            pw.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace(); //false thì tạo một ngoại lệ in ra lỗi
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

    //tìm brand theo ID - Dev by QuocDat
    public int searchID(String bID) {
        for (int i = 0; i < this.size(); i++) {
            if (bID.equals(this.get(i).getBrandID())) { //duyệt mảng tìm giá trị y hệt thì trả về 
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

    //add brand vào list - Dev by QuocDat
    public void addBrand() {
        int pos;
        String brandID;
        do {
            brandID = Extensions.getID("Input brand ID: ");
            pos = searchID(brandID); //tìm ID để xem ID muốn nhập đã tồn tại chưa
            if (pos >= 0) { //vị trí đã có trong list thì báo trùng
                System.out.println("This brand ID is existed. Try another one!");
            }
        } while (pos != -1); //vị trí không tồn tại trong list thì nhập các dữ liệu của brand
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

    
    //cập nhật brand với dữ liệu mới - Dev by QuocDat
    public void updateBrand() {
        String brandID = Extensions.getString("Enter brand ID: ");
        int index = searchID(brandID); //Nhập vào ID muốn thay đổi 
        if (index == -1) { //vị trí k tồn tại trong list thì báo k có
            System.out.println("Not found brand ID!");
        } else { //còn lại thì nhập dữ liệu bthg
             brandName = Extensions.getString("Enter brand name: ");
             soundBrand = Extensions.getString("Enter sound brand: ");
             price = Extensions.getPrice("Enter price: ", 0d, 100000000000d);
            Brand brand = new Brand(brandID, brandName, soundBrand, price);
            this.set(index, brand);
            System.out.println("Brand updated successfully!");
        }
    }
    
    //lấy vị trí của brand - Dev by QuocDat
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
            Collections.sort(this, new BrandIDComparator());
            //b1 b2 là đối tượng được generate từ random brand, b1.getBrandId là lấy id b1 so sánh với id b2
            //Dùng Collections.sort để sắp xếp danh sách trong Java là một cách tiện lợi. Nó  sắp xếp danh sách của bất kỳ đối tượng nào (các đối tượng triển khai giao diện Comparable hoặc cung cấp một Comparator riêng).
            //
        } else if (fieldChoice.equals("price")) {
            Collections.sort(this, new BrandPriceComparator());
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
        // "inc" (tăng dần) hoặc "dec" (giảm dần). 
        //orderChoice = scanner, nó sẽ đợi người dùng nhập một chuỗi từ bàn phím và sau đó trả về chuỗi đó. Chuỗi này sau đó được gán cho biến orderChoice
        if (orderChoice.equals("inc")) {
        System.out.println("Brand has been sorted in increasing order!");
        }
        else if (orderChoice.equals("dec")){
            Collections.reverse(this);
            System.out.println("Brand has been sorted in decreasing order!");    
        } else System.out.println("Invalid choice for sorting order.");
    
    }
    class BrandIDComparator implements Comparator<Brand> {

        @Override
        public int compare(Brand b1, Brand b2) {
            return b1.getBrandID().compareTo(b2.getBrandID());
        }
    }

    class BrandPriceComparator implements Comparator<Brand> {

        @Override
        public int compare(Brand b1, Brand b2) {
            return Double.compare(b1.getPrice(), b2.getPrice());
        }

    }
}
