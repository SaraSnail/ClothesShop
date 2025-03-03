package com.example.Controller;

import com.example.Model.BusinessObjects.Clothes.Skirt;

public class SkirtBuilder {
    private Skirt skirt = new Skirt();

    public SkirtBuilder(){

    }

    public SkirtBuilder addSize(Size size){
        skirt.setSize(size);
        return this;
    }

    public SkirtBuilder addMaterial(Material material){
        skirt.setMaterial(material);
        return this;
    }

    public SkirtBuilder addColor(Color color){
        skirt.setColor(color);
        return this;
    }

    public Skirt build(){
        if(skirt == null){
            throw new NullPointerException("skirt is null");
        }
        return skirt;
    }
}
