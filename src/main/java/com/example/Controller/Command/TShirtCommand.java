package com.example.Controller.Command;

import com.example.Controller.Util;
import com.example.Model.BusinessObjects.Clothes.Clothes;
import com.example.Model.BusinessObjects.Clothes.TShirt;

public class TShirtCommand implements ClothesProcessingCommand {

    @Override
    public Clothes process(Clothes clothes) {
        if(clothes.getName().equals("T-Shirt")){
            clothes = addSleeve(clothes);
            System.out.println();
            clothes = addNeck(clothes);
            return clothes;
        }else {
            System.out.println("Not instance of TShirt");
        }
        return null;
    }


    private Clothes addNeck(Clothes clothes) {
        System.out.println("[NECK]");
        System.out.println("1. CIRCLE\n2. V");
        int neckChoice = Util.getValidChoice(2);
        if(neckChoice == 1){
            ((TShirt)clothes).setNeck("CIRCLE");
        }else if(neckChoice == 2){
            ((TShirt)clothes).setNeck("V");
        }
        System.out.println("Measuring out the neck to be " + ((TShirt)clothes).getNeck().toLowerCase());

        return clothes;
    }

    private Clothes addSleeve(Clothes clothes) {
        System.out.println("[SLEEVES]");
        System.out.println("1. LONG\n2. SHORT");
        int sleevesChoice = Util.getValidChoice(2);
        if(sleevesChoice == 1){
            ((TShirt)clothes).setSleeves("LONG");
        }else if(sleevesChoice == 2){
            ((TShirt)clothes).setSleeves("SHORT");
        }

        System.out.println("Cutting out the sleeves to be " + ((TShirt)clothes).getSleeves().toLowerCase());
        return clothes;
    }
}
