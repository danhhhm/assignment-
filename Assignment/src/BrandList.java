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
    
    public int searchID(String bID){
        for(int i = 0; i<=this.size(); i++){
            if(bID.equals(this.get(i).getBrandID()))
                return i;
        }
        return -1;
    }
}
