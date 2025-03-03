package com.example.Model.BusinessObjects.Clothes;

import com.example.Controller.Color;
import com.example.Controller.Material;
import com.example.Controller.Size;

public class Pants extends Clothes{
    private String fit;
    private double length;

    public Pants() {
        this.name = "Pants";
        this.price = 199.89;
    }


    //Här anger jag inte priset i skapandet
    public Pants(int id, String name, Size size, Material material, Color color, String fit, double length) {
        super(id, name, size, material, color);
        this.fit = fit;
        this.length = length;
        this.price = 199.89;
    }



    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}
