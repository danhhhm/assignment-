/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author ADMIN
 */
public class Main {

    

    public static void main(String[] args) {
        // TODO code application logic here
        
        Menu<String> menu = new Menu<>();
        ArrayList<String> options = new ArrayList<>();
        options.add("Tùy chọn 1");
        options.add("Tùy chọn 2");
        options.add("Tùy chọn 3");

        int choice = menu.int_getChoice(options);
        System.out.println("Bạn đã chọn: " + options.get(choice - 1));

        String selectedOption = menu.ref_getChoice(options);
        System.out.println("Bạn đã chọn: " + selectedOption);

        menu.close();
    }
}
