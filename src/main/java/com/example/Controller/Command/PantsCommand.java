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

            //System.out.println(clothes.getName() + clothes.getId());
            clothes = addFit(clothes);
            clothes = addLength(clothes);

            return clothes;

        } else {
            System.out.println("Not instance of Pants");
        }
        return null;

    }


    private Clothes addFit(Clothes clothes) {

        System.out.println("[FIT]");
        System.out.println("1. Loose\n2. Tight");
        int choice = Util.getValidChoice(2);
        if(choice == 1){
            ((Pants)clothes).setFit("Loose");
        }else if(choice == 2){
            ((Pants)clothes).setFit("Tight");
        }

        /*String fit = (choice == 1) ? "Loose" : "Tight";
        ((Pants) clothes).setFit(fit);*/

        System.out.println("Measuring out a "+((Pants)clothes).getFit()+" fit");

        return clothes;
    }

    private Clothes addLength(Clothes clothes) {

        System.out.println("[LENGTH]");
        System.out.println("1. Long\n2. Short");
        int choice = Util.getValidChoice(2);
        if(choice == 1){
            ((Pants) clothes).setLength("Long");
        }else if(choice == 2){
            ((Pants) clothes).setLength("Short");
        }

        System.out.println("Cutting the pants to be " + ((Pants) clothes).getLength());

        return clothes;
    }

}
