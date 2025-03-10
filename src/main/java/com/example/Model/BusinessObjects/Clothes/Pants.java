package com.example.Model.BusinessObjects.Clothes;

import com.example.Model.Enums.Color;
import com.example.Model.Enums.Material;
import com.example.Model.Enums.Size;

public class Pants extends Clothes{
    private String fit;
    private String length;

    public Pants() {
        this.name = "Pants";
        this.price = 199.89;
    }


    public Pants(int id,  Size size, Material material, Color color, String fit, String length) {
        super(id, size, material, color);
        this.fit = fit;
        this.length = length;
        this.price = 199.89;
        this.name = "Pants";
    }



    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
