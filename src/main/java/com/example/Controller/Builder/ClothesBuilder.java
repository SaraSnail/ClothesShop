package com.example.Controller.Builder;

import com.example.Controller.Enums.Color;
import com.example.Controller.Enums.Material;
import com.example.Controller.Enums.Size;
import com.example.Controller.Observer.EventManager;
import com.example.Model.BusinessObjects.Clothes.Clothes;

public abstract class ClothesBuilder {
    protected EventManager eventManager = EventManager.getInstance();

    //Override för att inte skapa Clothes utan Pants/TShirt/Skirt
    protected Clothes clothes = createClothes();

    protected abstract Clothes createClothes();

    public ClothesBuilder addSize(Size size) {
        clothes.setSize(size);
        return this;
    }

    public ClothesBuilder addMaterial(Material material) {
        clothes.setMaterial(material);
        return this;
    }

    public ClothesBuilder addColor(Color color){
        clothes.setColor(color);
        return this;
    }

    public Clothes build(){
        if(clothes.getSize() == null){
            throw new RuntimeException("No size chosen");
        }
        if(clothes.getMaterial() == null){
            throw new RuntimeException("No material chosen");
        }
        if(clothes.getColor() == null){
            throw new RuntimeException("No color chosen");
        }
        return clothes;
    }
}
