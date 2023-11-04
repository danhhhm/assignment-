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
     public static int getChoice(Object[] option) {
        int i = 0;
        for (Object object : option) {
            i++;
            System.out.println(i + "-" + object);
        }

        int choice = Extensions.menuChoice("Choose 1.." + option.length+"\n", 1, option.length);

        return choice;
    }
    
    public static Object ref_getChoice(ArrayList<Object> option){

       Object[] brandarr = option.toArray();
       int choice = getChoice(brandarr);
       return option.get(choice-1);
    }
    
}
