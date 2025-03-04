package com.example.Controller.Builder;

import com.example.Controller.Enums.Color;
import com.example.Controller.Enums.Material;
import com.example.Controller.Enums.Size;
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
        if(skirt.getSize() == null){
            throw new NullPointerException("No size chosen");
        }
        if(skirt.getMaterial() == null){
            throw new NullPointerException("No material chosen");
        }
        if(skirt.getColor() == null){
            throw new NullPointerException("No color chosen");
        }
        return skirt;
    }
}
