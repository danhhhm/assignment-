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
    public static int int_getChoice(ArrayList<Brand > options) {
        int maxOp = options.size();
        int response;
        for (int i = 0; i < maxOp; i++) {
            System.out.println((i+1) + ". " + options.get(i));
        }
        System.out.println("Please chose an option [1..." + maxOp + "].");
        response = sc.nextInt();
        return response;
    }
    
    public static Object ref_getChoice(ArrayList<Brand> options){
        int maxOp = options.size();
        int response;
        System.out.println("BrandID list: ");
        do {            
            response = int_getChoice(options);
        } while (response < 0 || response > maxOp);
        return options.get(response-1);
    }
    
}
