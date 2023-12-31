/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
import java.util.*;
import java.lang.*;
public class Brand {
    private String brandID, brandName, soundBrand;
    private double price;

    public Brand() {
        this.brandID = "";
        this.brandName = "";
        this.soundBrand = "";
        this.price = 0;
    }

    public Brand(String brandID, String brandName, String soundBrand, double price) {
        this.brandID = brandID;
        this.brandName = brandName;
        this.soundBrand = soundBrand;
        this.price = price;
    }

    public void setUpdateBrand(String brandName, String soundBrand, double price) {
        this.brandName = brandName;
        this.soundBrand = soundBrand;
        this.price = price;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getSoundBrand() {
        return soundBrand;
    }

    public double getPrice() {
        return price;
    }

    public String getBrandID() {
        return brandID;
    }
        
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": brandID = " + brandID + ", brandName = " + brandName + ", soundBrand = " + soundBrand + ", price = " + price;
    }
    
}
