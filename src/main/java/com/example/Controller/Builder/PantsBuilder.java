package com.example.Controller.Builder;

import com.example.Controller.Enums.Color;
import com.example.Controller.Enums.Material;
import com.example.Controller.Enums.Size;
import com.example.Controller.Observer.EventManager;
import com.example.Model.BusinessObjects.Clothes.Pants;

public class PantsBuilder{
    private Pants pants = new Pants();
    private EventManager eventManager = EventManager.getInstance();

    public PantsBuilder() {
        eventManager.notifyListeners("Pants creation started");
    }

    //price, size, material, color,
    public PantsBuilder addSize(Size size) {
        pants.setSize(size);
        return this;
    }

    public PantsBuilder addMaterial(Material material) {
        pants.setMaterial(material);


        return this;
    }

    public PantsBuilder addColor(Color color) {
        pants.setColor(color);
        return this;
    }

    public Pants build() {
        if(pants.getMaterial() == null) {
            throw new RuntimeException("No material chosen");
        }
        if(pants.getSize() == null) {
            throw new RuntimeException("No size chosen");
        }
        if(pants.getColor() == null) {
            throw new RuntimeException("No color chosen");
        }
        return pants;
    }
}
