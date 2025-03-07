package com.example.Controller.Builder;

import com.example.Model.BusinessObjects.Clothes.Clothes;
import com.example.Model.BusinessObjects.Clothes.Skirt;

public class SkirtBuilder extends ClothesBuilder{
    @Override
    protected Clothes createClothes() {
        eventManager.notifyListeners("Skirt started creation");
        return new Skirt();
    }

}
