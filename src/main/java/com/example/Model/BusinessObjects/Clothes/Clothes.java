package com.example.Model.BusinessObjects.Clothes;

import com.example.Controller.Size;
import com.example.Model.BusinessObjects.BusinessObject;

public abstract class Clothes extends BusinessObject {
    protected double price;
    private Size size;//Kolla på example enum
    private String material;
    private String color;

    public Clothes() {
    }

    public Clothes(int id, String name, double price, Size size, String material, String color) {
        super(id, name);
        this.price = price;
        this.size = size;
        this.material = material;
        this.color = color;
    }

    public Clothes(int id, String name, Size size, String material, String color) {
        super(id, name);
        this.size = size;
        this.material = material;
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
