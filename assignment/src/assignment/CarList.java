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


public class CarList {
    
    
    private ArrayList<Car> cars;
    private BrandList brandList;
    
    
public CarList(BrandList bList){
    this.cars = new ArrayList<>();
    brandList = bList;
    
}


public boolean loadFromFile(String filename){
    File f = new File (filename);
    if (!f.exists()) return false;
    else 
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
                String[] parts = line.split(", ");
                if (parts.length == 5) {
                    String carID = parts[0];
                    
                    String color = parts [2];
                    String frameID = parts [3];
                    String engineID = parts [4];
                }
                
                
            }catch 
                
}




    
    
}
