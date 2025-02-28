package com.example.Model.BusinessObjects.Clothes;

import com.example.Controller.Color;
import com.example.Controller.Material;
import com.example.Controller.Size;

public class Skirt extends Clothes{
    private int waistline;//int eller String?
    private String pattern;

    public Skirt() {
    }

    public Skirt(int id, String name, double price, Size size, Material material, Color color, int waistline, String pattern) {
        super(id, name, price, size, material, color);
        this.waistline = waistline;
        this.pattern = pattern;
    }

    public int getWaistline() {
        return waistline;
    }

    public void setWaistline(int waistline) {
        this.waistline = waistline;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
