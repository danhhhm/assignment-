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
import java.text.DecimalFormat;
public class Extensions {
    private final static Scanner sc = new Scanner(System.in);
    
    public static String getString(String inputString) {
        String input;
        while (true) {
            try {
                System.out.print(inputString);
                input = sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.err.println("Error: You must enter a string. Please try again.");
                sc.nextLine();
            }
        }
        return input.trim();
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
    public static double getDouble(String inputMsg) {
        double n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println("Price must be real number");
            }
        }
    }
    public static String getID(String inputID, String outputSring, String format) {
        String id;
        boolean match;
        while (true) {
            System.out.print(inputID);
            id = sc.nextLine().trim().toUpperCase();
            match = id.matches(format);
            if (id.length() == 0 || id.isEmpty() || match == false) {
                System.out.println(outputSring);
            } else {
                return id;
            }
        }
    }
    
    public static String getID(String inputID) {
        String id;
        while(true) {
            System.out.println(inputID);
        id = sc.nextLine().trim().toUpperCase();
        if(id.length()==0 || id.isEmpty()){
            System.out.println("The ID must not be null. Try again!");
        } else {
            return id;
        }
        }
    }
    public static int getInt(String inputInt, int min, int max) {
        int num;
        while(true) {
            try {
                System.out.println(inputInt);
                num = sc.nextInt();
                sc.nextLine();
                if(num >= min && num <= max) {
                    break;
                } else {
                    System.err.println("Input must be between: " +min+ " and " +max+ "Please try again!");
                }
            } catch (Exception e) {
                System.err.println("you must enter a integer.Please try again!");
                sc.nextLine();
            }
        }
        return num;
    }
    public static int menuChoice(String input,int min, int max) {
        int num;
        while(true) {
            try {
                System.out.println(input);
                num = sc.nextInt();
                sc.nextLine();
                if(num >= min && num <= max) {
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
    public static double getRound(double k, String pattern) {
        DecimalFormat df = new DecimalFormat(pattern);
        String s = df.format(k);
        double result = Double.parseDouble(s);
        return result;
    }
    public static int genRandomInt() {
        Random rand = new Random();
        return rand.nextInt();
    }

    public static double genRandomDoubleInRange(double min, double max) {
        if (min >= max) {
            throw new IllegalArgumentException("min must be less than max");
        }

        Random rand = new Random();
        return min + (max - min) * rand.nextDouble();
    }
    
    public static int genRandomIntInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("min must be less than max");
        }

        Random rand = new Random();
        // Use the nextInt method to generate a random integer within the range [min, max)
        return rand.nextInt(max - min + 1) + min;
    }
    
    public static String genRandomBrandID(ArrayList<String> usedIDs) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder brandID = new StringBuilder();

        do {
            int x = genRandomIntInRange(0, 9); // Số từ 0-9
            char y = alphabet.charAt(genRandomIntInRange(0, alphabet.length() - 1)); // Một chữ cái
            char z = alphabet.charAt(genRandomIntInRange(0, alphabet.length() - 1)); // Một chữ cái
            int a = genRandomIntInRange(0, 9); 
            int b = genRandomIntInRange(0, 9);

            brandID.setLength(0); // Xóa bỏ nội dung cũ
            brandID.append("B"); // Chữ "B" đứng đầu
            brandID.append(x);
            brandID.append("-");
            brandID.append(y);
            brandID.append(z);
            brandID.append(a);
            brandID.append(b);
        } while (usedIDs.contains(brandID.toString()));

        return brandID.toString();
    }
    
    public static String genRandomBrandName() {
        String[] bn = {"BMW X5", "BMW M3", "BMW 7 Series", "BMW i8", "BMW Z4", "BMW 3 Series", "BMW X3", "BMW 5 Series", "BMW X7", "BMW X1", "BMW X6", "BMW M4", "BMW 8 Series", "BMW i3", "BMW 1 Series", "BMW X2", "BMW M5", "BMW 6 Series", "BMW M2", "BMW X4"};
        return bn[genRandomIntInRange(0, bn.length - 1)];      
    }
    
    public static String genRandomSoundBrand() {
        String[] sb = {"SoundXperience", "SonicWave", "AudioZen", "HarmonicBeats", "SoundSculpt", "AcousticPulse", "SonicHarbor", "MeloGroove", "HarmonyWave", "EchoVibes", "SoniBlend", "AcousticPulse", "ResoTune", "SonicSphere", "VibeWave", "HarmonixRhythm", "PulseFusion", "EchoDynamics", "SoundWavesX", "AcousticMomentum"};
        return sb[genRandomIntInRange(0, sb.length - 1)];
    }
    
    public static String genRandomColor() {
        String[] colors = {"red", "green", "blue", "yellow", "black", "white", "brown", "cyan",
            "magenta", "pink", "gray", "orange", "purple", "violet", "tomato"};
        return colors[genRandomIntInRange(0, colors.length - 1)];
    }
    
    public static String genRandomFrameID(ArrayList<String> usedIDs) {   
        StringBuilder frameID = new StringBuilder();

        do {
            int num1 = genRandomIntInRange(0, 9); // Số từ 0-9
            int num2 = genRandomIntInRange(0, 9); 
            int num3 = genRandomIntInRange(0, 9);
            int num4 = genRandomIntInRange(0, 9);
            int num5 = genRandomIntInRange(0, 9);

            frameID.setLength(0); // Xóa bỏ nội dung cũ
            frameID.append("F"); // Chữ "F" đứng đầu
            frameID.append(num1);
            frameID.append(num2);
            frameID.append(num3); 
            frameID.append(num4);
            frameID.append(num5);
        } while (usedIDs.contains(frameID.toString()));
        return frameID.toString();
    }
    
    public static String genRandomCarID(ArrayList<String> usedIDs) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder carID = new StringBuilder();

        do {
            int x = genRandomIntInRange(0, 9); // Số từ 0-9
            char y = alphabet.charAt(genRandomIntInRange(0, alphabet.length() - 1)); // Một chữ cái
            char z = alphabet.charAt(genRandomIntInRange(0, alphabet.length() - 1)); // Một chữ cái
            int a = genRandomIntInRange(0, 9); 
            int b = genRandomIntInRange(0, 9);

            carID.setLength(0); // Xóa bỏ nội dung cũ
            carID.append("C"); // Chữ "C" đứng đầu
            carID.append(x);
            carID.append(y);
            carID.append(z);
            carID.append(a);
            carID.append(b);
        } while (usedIDs.contains(carID.toString()));

        return carID.toString();
    }
}

