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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.lang.*;
public class FileIO {
    public static boolean writeFile(String filePath, String content) {
        try {
            File f1 = new File(filePath);
            FileWriter fw = new FileWriter(f1);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
            bw.flush();
            return true;
        } catch (Exception e) {
            System.err.println("Error writing to file: " + e.getMessage());
            return false;
        }
    }
    
    public static boolean appendFile(String filePath, String content) {
        try {
            File f1 = new File(filePath);
            FileWriter fw = new FileWriter(f1, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
            bw.flush();
            return true;
        } catch (Exception e) {
            System.err.println("Error appending to file: " + e.getMessage());
            return false;
        }
    }
    
    public static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try {
            File f1 = new File(filePath);
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return content.toString();
    }
}
