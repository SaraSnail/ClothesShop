package com.example.Model.BusinessObjects.Clothes;

import com.example.Controller.Enums.Color;
import com.example.Controller.Enums.Material;
import com.example.Controller.Enums.Size;

public class Skirt extends Clothes{
    private String waistline;
    private String pattern;

    public Skirt() {
        this.name = "Skirt";
        this.price = 149.99;
    }

    public Skirt(int id, Size size, Material material, Color color, String waistline, String pattern) {
        super(id, size, material, color);
        this.waistline = waistline;
        this.pattern = pattern;
        this.price = 149.99;
        this.name = "Skirt";
    }

    public String getWaistline() {
        return waistline;
    }

    public void setWaistline(String waistline) {
        this.waistline = waistline;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
