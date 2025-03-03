package com.example.Model.BusinessObjects.Clothes;

import com.example.Controller.Color;
import com.example.Controller.Material;
import com.example.Controller.Size;

public class TShirt extends Clothes{
    private String sleeves;
    private String neck;//Typ av nack-utringning

    public TShirt() {
        this.price = 99.9;
        this.name = "T-Shirt";
    }

    public TShirt(int id, Size size, Material material, Color color, String sleeves, String neck) {
        super(id, size, material, color);
        this.sleeves = sleeves;
        this.neck = neck;
        this.price = 100;
        this.name = "T-Shirt";
    }

    public String getSleeves() {
        return sleeves;
    }

    public void setSleeves(String sleeves) {
        this.sleeves = sleeves;
    }

    public String getNeck() {
        return neck;
    }

    public void setNeck(String neck) {
        this.neck = neck;
    }
}
