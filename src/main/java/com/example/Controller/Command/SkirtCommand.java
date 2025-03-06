package com.example.Controller.Command;

import com.example.Model.BusinessObjects.Clothes.Clothes;
import com.example.Model.BusinessObjects.Clothes.Skirt;

public class SkirtCommand implements ClothesProcessingCommand {
    private String waistline;
    private String pattern;

    public SkirtCommand(String waistline, String pattern) {
        this.waistline = waistline;
        this.pattern = pattern;
    }

    @Override
    public Clothes process(Clothes clothes) {
        if(clothes instanceof Skirt){
            ((Skirt)clothes).setWaistline(waistline);
            System.out.println("Measuring out the waistline to be " + ((Skirt) clothes).getWaistline().toLowerCase());
            ((Skirt)clothes).setPattern(pattern);
            System.out.println("Cutting from the " + ((Skirt)clothes).getPattern().toLowerCase() + " pattern");

            return clothes;
        }else {
            System.out.println("No instance of Skirt");
        }
        return null;
    }

}
