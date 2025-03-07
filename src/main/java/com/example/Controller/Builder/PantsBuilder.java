package com.example.Controller.Builder;

import com.example.Model.BusinessObjects.Clothes.Clothes;
import com.example.Model.BusinessObjects.Clothes.Pants;

public class PantsBuilder extends ClothesBuilder{

    @Override
    protected Clothes createClothes() {
        eventManager.notifyListeners("Pants started creation");
        return new Pants();
    }
}
