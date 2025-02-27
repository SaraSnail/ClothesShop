package com.example.Model.BusinessObjects.Clothes;

import com.example.Controller.Size;

public class TShirt extends Clothes{
    private int sleeves;
    private String neck;//Typ av nack-utringning

    public TShirt() {
    }

    public TShirt(int id, String name, double price, Size size, String material, String color, int sleeves, String neck) {
        super(id, name, price, size, material, color);
        this.sleeves = sleeves;
        this.neck = neck;
        this.price = 100;
    }

    public int getSleeves() {
        return sleeves;
    }

    public void setSleeves(int sleeves) {
        this.sleeves = sleeves;
    }

    public String getNeck() {
        return neck;
    }

    public void setNeck(String neck) {
        this.neck = neck;
    }
}
