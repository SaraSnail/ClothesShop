package com.example.Controller;

import com.example.Model.BusinessObjects.Clothes.Clothes;
import com.example.Model.BusinessObjects.Clothes.TShirt;

public class TShirtCommand implements ClothesProcessingCommand{


    @Override
    public Clothes process(Clothes clothes) {
        if(clothes.getName().equals("T-Shirt")){
            clothes = addSleeve(clothes);
            clothes = addNeck(clothes);
            return clothes;
        }else {
            System.out.println("Not instance of TShirt");
        }
        return null;
    }


    private Clothes addNeck(Clothes clothes) {
        System.out.println("Neck\n1. Loose\n2. Tight");
        int neckChoice = Util.getValidChoice(2);
        if(neckChoice == 1){
            ((TShirt)clothes).setNeck("Loose");
        }else if(neckChoice == 2){
            ((TShirt)clothes).setNeck("Tight");
        }
        System.out.println("Measuring out the neck to be " + ((TShirt)clothes).getNeck());

        return clothes;
    }

    private Clothes addSleeve(Clothes clothes) {
        System.out.println("Sleeves\n1. Long\n2. Short");
        int sleevesChoice = Util.getValidChoice(2);
        if(sleevesChoice == 1){
            ((TShirt)clothes).setSleeves("Long");
        }else if(sleevesChoice == 2){
            ((TShirt)clothes).setSleeves("Short");
        }

        System.out.println("Cutting out the sleeves to be " + ((TShirt)clothes).getSleeves());
        return clothes;
    }
}
