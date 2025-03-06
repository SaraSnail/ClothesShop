package com.example.Controller.Command;

import com.example.Model.BusinessObjects.Clothes.Clothes;
import com.example.Model.BusinessObjects.Clothes.TShirt;

public class TShirtCommand implements ClothesProcessingCommand {
    private String neck;
    private String sleeved;

    public TShirtCommand(String neck, String sleeved) {
        this.neck = neck;
        this.sleeved = sleeved;
    }

    @Override
    public Clothes process(Clothes clothes) {
        if(clothes instanceof TShirt) {

            ((TShirt)clothes).setNeck(neck);
            System.out.println("Measuring out the neck to be " + ((TShirt)clothes).getNeck().toLowerCase());
            ((TShirt)clothes).setSleeves(sleeved);
            System.out.println("Cutting out the sleeves to be " + ((TShirt)clothes).getSleeves().toLowerCase());

            return clothes;
        }else {
            System.out.println("Not instance of TShirt");
        }
        return null;
    }

}
