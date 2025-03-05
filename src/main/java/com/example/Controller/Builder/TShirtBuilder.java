package com.example.Controller.Builder;

import com.example.Controller.Enums.Color;
import com.example.Controller.Enums.Material;
import com.example.Controller.Enums.Size;
import com.example.Controller.Observer.EventManager;
import com.example.Model.BusinessObjects.Clothes.Clothes;
import com.example.Model.BusinessObjects.Clothes.TShirt;

public class TShirtBuilder extends ClothesBuilder{
    @Override
    protected Clothes createClothes() {
        eventManager.notifyListeners("T-Shirt started creation");
        return new TShirt();
    }


    /*private TShirt tShirt = new TShirt();
    private EventManager eventManager = EventManager.getInstance();

    public TShirtBuilder() {
        eventManager.notifyListeners("T-Shirt creation started");
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
        if (tShirt.getSize() == null) {
            throw new NullPointerException("No size chosen");
        }
        if (tShirt.getMaterial() == null) {
            throw new NullPointerException("No material chosen");
        }
        if (tShirt.getColor() == null) {
            throw new NullPointerException("No color chosen");
        }
        return tShirt;
    }*/
}
