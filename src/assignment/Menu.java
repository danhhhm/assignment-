/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import Extend.Extensions;
import java.util.*;
import java.lang.*;

public class Menu {

    private static Scanner sc = new Scanner(System.in);
    private String input;
    private static ArrayList<String> list = new ArrayList();

    public Menu() {
    }

    public Menu(String input) {
        this.input = input;
    }

    public void addOptions(String options) {
        list.add(options);
    }

    public static int int_getChoice() {
        int maxOp = list.size();
        int response;
        for (int i = 0; i < maxOp; i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
        System.out.println("Please chose an option [1..." + maxOp + "].");
        response = sc.nextInt();
        return response;
    }
    
    public static int int_getChoice(ArrayList<Brand> options) {
        int maxOp = options.size();
        int response;
        for (int i = 0; i < maxOp; i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
        System.out.println("Please chose an option [1..." + maxOp + "].");
        response = sc.nextInt();
        return response;
    }

    public static Object ref_getChoice(ArrayList<Brand> options) {
        int maxOp = options.size();
        int response;
        System.out.println("BrandID list: ");
        do {
            response = int_getChoice(options);
        } while (response < 0 || response > maxOp);
        return options.get(response - 1);
    }

}
