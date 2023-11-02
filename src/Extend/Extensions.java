/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Extend;

/**
 *
 * @author Admin
 */
import java.util.*;
import java.lang.*;
public class Extensions {
    private final static Scanner sc = new Scanner(System.in);
    public static String getString(String inputString) {
        String str;
        while(true) {
            System.out.println(inputString);
            str = sc.nextLine().trim();
            if(str.length()==0|| str.isEmpty()) {
                System.out.println("The string must not be null. Please try again!");
            } else {
                return str;
            }
        }
    }
    public static double getPrice(String inputPrice, double min, double max) {
        double num;
        while(true){
            try{
                System.out.println(inputPrice);
                num = sc.nextDouble(); 
                sc.nextLine();
                if(num>=min && num <= max) {
                    break;
                } else {
                    System.out.println("Error: InputPrice must be between: "+min+ " and " +max+". Please try again!");
                }
                
            } catch(Exception e) {
                System.out.println("Price must be real number");
            }   
        }
        return num;
    }
    
    public static String getID(String inputID) {
        String id;
        while(true) {
            System.out.println(inputID);
        id = sc.nextLine().trim().toUpperCase();
        if(id.length()==0 || id.isEmpty()){
            System.out.println("The brandID must not be null. Try again!");
        } else {
            return id;
        }
        }
    }
}

