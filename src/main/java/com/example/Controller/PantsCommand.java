package com.example.Controller;

import com.example.Model.BusinessObjects.Clothes.Clothes;
import com.example.Model.BusinessObjects.Clothes.Pants;

import java.util.Scanner;

public class PantsCommand implements ClothesProcessingCommand{
    //private Scanner scanner = new Scanner(System.in);

    @Override
    public Clothes process(Clothes clothes) {
        if(clothes instanceof Pants){

            clothes = addFit(clothes);
            clothes = addLength(clothes);

            return clothes;
        }else {
            return null;
        }

    }

    private Clothes addFit(Clothes clothes) {

        System.out.println("1. Loose\n2. Tight");
        int choice = Util.getValidChoice(2);
        if(choice == 1){
            ((Pants)clothes).setFit("Loose");
        }else if(choice == 2){
            ((Pants)clothes).setFit("Tight");
        }

        return clothes;
    }

    private Clothes addLength(Clothes clothes) {

        System.out.println("1. Long\n2. Short");
        int choice = Util.getValidChoice(2);
        if(choice == 1){
            ((Pants) clothes).setLength("Long");
        }else if(choice == 2){
            ((Pants) clothes).setLength("Short");
        }


        return clothes;
    }

    //Samma som i Meny, flytta så båda kan nå denna?
   /* private int getValidChoice(int maxOptions){
        int choice = -1;
        while(choice < 1 || choice > maxOptions){
            try{
                String input = scanner.nextLine();
                choice = Integer.parseInt(input);
                if(choice < 1 || choice > maxOptions){
                    System.out.println("Please enter a number between 1 and "+maxOptions);
                }
            }catch (NumberFormatException e){
                System.out.println("Please enter a valid number");
            }
        }
        return choice;
    }*/
}
