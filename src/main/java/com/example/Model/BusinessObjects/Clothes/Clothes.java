package com.example.Model.BusinessObjects.Clothes;

import com.example.Controller.Color;
import com.example.Controller.Material;
import com.example.Controller.Size;
import com.example.Model.BusinessObjects.BusinessObject;

public abstract class Clothes extends BusinessObject {
    protected double price;
    private Size size;//Kolla på example enum
    private Material material;
    private Color color;

    public Clothes() {
    }

    public Clothes(int id, String name, double price, Size size, Material material, Color color) {
        super(id, name);
        this.price = price;
        this.size = size;
        this.material = material;
        this.color = color;
    }


    public Clothes(int id, String name, Size size, Material material, Color color) {
        super(id, name);
        this.size = size;
        this.material = material;
        this.color = color;
    }

    public Clothes(int id, Size size, Material material, Color color) {
        super(id);
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

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
