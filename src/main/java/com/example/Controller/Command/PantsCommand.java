package com.example.Controller.Command;

import com.example.Model.BusinessObjects.Clothes.Clothes;
import com.example.Model.BusinessObjects.Clothes.Pants;

public class PantsCommand implements ClothesProcessingCommand {

    private String fit;
    private String length;

    public PantsCommand(String fit, String length) {
        this.fit = fit;
        this.length = length;
    }

    @Override
    public Clothes process(Clothes clothes) {
        if(clothes instanceof Pants) {
            ((Pants)clothes).setFit(fit);
            System.out.println("Measuring out a " + ((Pants)clothes).getFit().toLowerCase() + " fit");
            ((Pants)clothes).setLength(length);
            System.out.println("Cutting out the pants to be " + ((Pants)clothes).getLength().toLowerCase() + " length");

            return clothes;

        } else {
            System.out.println("Not instance of Pants");
        }

        return null;

    }

}
