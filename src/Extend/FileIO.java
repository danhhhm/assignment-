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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
        } catch (Exception e) {
        }
    }
}
