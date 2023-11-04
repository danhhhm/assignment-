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
        while (true) {
            System.out.println(inputString);
            str = sc.nextLine().trim();
            if (str.length() == 0 || str.isEmpty()) {
                System.out.println("The input string must not be null. Please try again!");
            } else {
                return str;
            }
        }
    }

    public static double getPrice(String inputPrice, double min, double max) {
        double num;
        while (true) {
            try {
                System.out.println(inputPrice);
                num = sc.nextDouble();
                sc.nextLine();
                if (num >= min && num <= max) {
                    break;
                } else {
                    System.out.println("Error: InputPrice must be between: " + min + " and " + max + ". Please try again!");
                }

            } catch (Exception e) {
                System.out.println("Price must be real number");
            }
        }
        return num;
    }

    public static String getID(String inputID) {
        String id;
        while (true) {
            System.out.println(inputID);
            id = sc.nextLine().trim().toUpperCase();
            if (id.length() == 0 || id.isEmpty()) {
                System.out.println("The ID must not be null. Try again!");
            } else {
                return id;
            }
        }
    }

    public static int getInt(String inputInt, int min, int max) {
        int num;
        while (true) {
            try {
                System.out.println(inputInt);
                num = sc.nextInt();
                sc.nextLine();
                if (num >= min && num <= max) {
                    break;
                } else {
                    System.err.println("Input must be between: " + min + " and " + max + "Please try again!");
                }
            } catch (Exception e) {
                System.err.println("you must enter a integer.Please try again!");
                sc.nextLine();
            }
        }
        return num;
    }

    public static int menuChoice(String input, int min, int max) {
        int num;
        while (true) {
            try {
                System.out.println(input);
                num = sc.nextInt();
                sc.nextLine();
                if (num >= min && num <= max) {
                    break;
                } else {
                    System.out.println("");
                }
            } catch (Exception e) {
                System.out.println("Invalid choice. Please choose again.");
                sc.nextLine();
            }
        }
        return num;
    }
    
    public static String genRandomBrandID() {
        Random rand = new Random();
        int randInt = 10000 + rand.nextInt(90000); // Random 5-digit number
        return "B" + randInt;
    }

    public static String genRandomBrandName() {
        String[] brandNames = { "Toyota", "Honda", "Ford", "Chevrolet", "Nissan", "Hyundai", "Volkswagen", "BMW" };
        Random rand = new Random();
        int randIndex = rand.nextInt(brandNames.length);
        return brandNames[randIndex];
    }

    public static String genRandomSoundBrand() {
        String[] soundBrands = { "Bose", "Harman Kardon", "JBL", "Sony", "Pioneer" };
        Random rand = new Random();
        int randIndex = rand.nextInt(soundBrands.length);
        return soundBrands[randIndex];
    }

    public static double genRandomPrice() {
        Random rand = new Random();
        double minPrice = 10000.0;
        double maxPrice = 50000.0;
        return minPrice + (maxPrice - minPrice) * rand.nextDouble();
    }
}
