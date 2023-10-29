/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment;

import java.util.*;
import java.lang.*;
public class Menu {
    public static int getChoice(Object[] option){
        for(int i = 0; i<option.length; i++){
            System.out.println(((i+1) + "-" + option[i]));
        }
        System.out.println("Choice 1.." + option.length + ": ");
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }
    
    
}
