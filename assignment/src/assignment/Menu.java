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
import java.lang.*;
import static java.lang.Math.E;
import static java.lang.StrictMath.E;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu <E>{

    Scanner scanner = new Scanner(System.in);
    /*public void menu(){
    System.out.println("1- List all brands");
    System.out.println("2- Add a new brand");
    System.out.println("3- Search a brand based on its ID");
    System.out.println("4- Update a brand");
    System.out.println("5- Save brands to the file, named brands.txt");
    System.out.println("6- List all cars in ascending order of brand names");
    System.out.println("7- List cars based on a part of an input brand name");
    System.out.println("8- Add a car");
    System.out.println("9- Remove a car based on its ID");
    System.out.println("10- Update a car based on its ID");
    System.out.println("11- Save cars to file, named cars.txt");
    }*/

    public Menu() {
        scanner = new Scanner(System.in);
    }

    
    public int int_getChoice(ArrayList<E> options){
        int choice = -1;
        while (true) {
            System.out.println("pick 1 from these choice: ");
                for (int i = 0; i< options.size();i++){
                    System.out.println((i+1) + ". " + options.get(i) );
                    
                }
                System.out.println(" your choice:  ");
            try{
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= options.size()) {
                    break;
                }else {
                    System.out.println("option not existed, choose again: ");
                }
            } catch(NumberFormatException e){
                System.out.println("errror! Choose again: ");
            }
        }
        return choice;
    }
    
    public E ref_getChoice(ArrayList<E> options) {
        int choice = int_getChoice(options);
        return options.get(choice - 1);
    }
    
    public void close() {
        scanner.close();
    }


}