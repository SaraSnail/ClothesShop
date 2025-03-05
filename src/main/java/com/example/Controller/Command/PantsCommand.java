package com.example.Controller.Command;

import com.example.Controller.Util;
import com.example.Model.BusinessObjects.Clothes.Clothes;
import com.example.Model.BusinessObjects.Clothes.Pants;

public class PantsCommand implements ClothesProcessingCommand {

    @Override
    public Clothes process(Clothes clothes) {
        if(clothes == null){
            System.out.println("Null");

        } else if (clothes.getName().equals("Pants")) {

            clothes = addFit(clothes);
            System.out.println();
            clothes = addLength(clothes);

            return clothes;

        } else {
            System.out.println("Not instance of Pants");
        }
        return null;

    }


    private Clothes addFit(Clothes clothes) {

        System.out.println("[FIT]");
        System.out.println("1. LOOSE\n2. TIGHT");
        int choice = Util.getValidChoice(2);
        if(choice == 1){
            ((Pants)clothes).setFit("LOOSE");
        }else if(choice == 2){
            ((Pants)clothes).setFit("TIGHT");
        }

        /*String fit = (choice == 1) ? "Loose" : "Tight";
        ((Pants) clothes).setFit(fit);*/

        System.out.println("Measuring out a "+((Pants)clothes).getFit().toLowerCase()+" fit");

        return clothes;
    }

    private Clothes addLength(Clothes clothes) {

        System.out.println("[LENGTH]");
        System.out.println("1. LONG\n2. SHORT");
        int choice = Util.getValidChoice(2);
        if(choice == 1){
            ((Pants) clothes).setLength("LONG");
        }else if(choice == 2){
            ((Pants) clothes).setLength("SHORT");
        }

        System.out.println("Cutting the pants to be " + ((Pants) clothes).getLength().toLowerCase());

        return clothes;
    }

}
