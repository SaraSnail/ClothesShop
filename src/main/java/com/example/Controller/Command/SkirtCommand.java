package com.example.Controller.Command;

import com.example.Controller.Util;
import com.example.Model.BusinessObjects.Clothes.Clothes;
import com.example.Model.BusinessObjects.Clothes.Skirt;

public class SkirtCommand implements ClothesProcessingCommand {

    @Override
    public Clothes process(Clothes clothes) {
        if(clothes instanceof Skirt){
            clothes = addWaistline(clothes);
            System.out.println();
            clothes = addPattern(clothes);
            return clothes;
        }else {
            System.out.println("No instance of Skirt");
        }
        return null;
    }


    private Clothes addWaistline(Clothes clothes){
        System.out.println("[WAISTLINE]");
        System.out.println("1. STRETCHY\n2. FIRM FIT");
        int waistlineChoice = Util.getValidChoice(2);
        if(waistlineChoice == 1){
            ((Skirt) clothes).setWaistline("STRETCHY");
        }else if(waistlineChoice == 2){
            ((Skirt) clothes).setWaistline("FIRM FIT");
        }

        System.out.println("Measuring out the waistline to be " + ((Skirt) clothes).getWaistline().toLowerCase());

        return clothes;
    }

    private Clothes addPattern(Clothes clothes){
        System.out.println("[PATTERN]");
        System.out.println("1. SINGULAR COLOR\n2. STRIPED");
        int patternChoice = Util.getValidChoice(2);
        if(patternChoice == 1){
            ((Skirt) clothes).setPattern("SINGULAR COLOR");
        }else if(patternChoice == 2){
            ((Skirt) clothes).setPattern("STRIPED");
        }

        System.out.println("Cutting from the " + ((Skirt)clothes).getPattern().toLowerCase() + " pattern");

        return clothes;
    }
}
