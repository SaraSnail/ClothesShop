package com.example.Model.Builder;

import com.example.Model.BusinessObjects.Clothes.Clothes;
import com.example.Model.BusinessObjects.Clothes.TShirt;

public class TShirtBuilder extends ClothesBuilder{
    @Override
    protected Clothes createClothes() {
        eventManager.notifyListeners("T-Shirt started creation");
        return new TShirt();
    }

}
