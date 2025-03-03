package com.example.Controller;

import com.example.Model.BusinessObjects.Clothes.TShirt;

public class TShirtBuilder {
    private TShirt tShirt = new TShirt();

    public TShirtBuilder() {

    }

    public TShirtBuilder addSize(Size size) {
        tShirt.setSize(size);
        return this;
    }

    public TShirtBuilder addMaterial(Material material) {
        tShirt.setMaterial(material);
        return this;
    }

    public TShirtBuilder addColor(Color color) {
        tShirt.setColor(color);
        return this;
    }

    public TShirt build() {
        if (tShirt == null) {
            throw new NullPointerException("tShirt is null");
        }
        return tShirt;
    }
}
