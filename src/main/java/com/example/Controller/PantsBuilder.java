package com.example.Controller;

import com.example.Model.BusinessObjects.Clothes.Pants;

public class PantsBuilder {
    private Pants pants = new Pants();

    public PantsBuilder() {

    }

    //price, size, material, color,
    public PantsBuilder addSize(Size size) {
        //if(size.matches(String.valueOf(Size.SMALL)));//Kolla hur man jobbar med enum
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
        if(pants.getMaterial() == null || pants.getMaterial().equals("")) {
            throw new RuntimeException("No material chosen");
        }
        return pants;
    }
}
