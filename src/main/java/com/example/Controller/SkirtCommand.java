package com.example.Controller;

import com.example.Model.BusinessObjects.Clothes.Clothes;
import com.example.Model.BusinessObjects.Clothes.Skirt;

public class SkirtCommand implements ClothesProcessingCommand{
    @Override
    public Clothes process(Clothes clothes) {
        if(clothes instanceof Skirt){
            clothes = addWaistline(clothes);
            clothes = addPattern(clothes);
            return clothes;
        }else {
            System.out.println("No instance of Skirt");
        }
        return null;
    }


    private Clothes addWaistline(Clothes clothes){
        System.out.println("Waistline\n1. Stretchy\n2. Firm fit");
        int waistlineChoice = Util.getValidChoice(2);
        if(waistlineChoice == 1){
            ((Skirt) clothes).setWaistline("Stretchy");
        }else if(waistlineChoice == 2){
            ((Skirt) clothes).setWaistline("Firm fit");
        }

        System.out.println("Measuring out the waistline to be " + ((Skirt) clothes).getWaistline());

        return clothes;
    }

    private Clothes addPattern(Clothes clothes){
        System.out.println("Pattern\n1. One color\n2. Striped");
        int patternChoice = Util.getValidChoice(2);
        if(patternChoice == 1){
            ((Skirt) clothes).setPattern("One color");
        }else if(patternChoice == 2){
            ((Skirt) clothes).setPattern("Striped");
        }

        System.out.println("Cutting from the " + ((Skirt)clothes).getPattern() + " pattern");

        return clothes;
    }
}
