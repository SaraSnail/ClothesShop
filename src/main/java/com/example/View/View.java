package com.example.View;

import com.example.Controller.*;
import com.example.Model.BusinessObjects.Receipt;

import java.util.List;
import java.util.Scanner;

public class View {
    private static Scanner scanner = new Scanner(System.in);

    public static void displayWelcomeMessage(){
        System.out.println("Welcome! Please enter the following materials:");
    }

    public static String getUserInput(String input){
        System.out.print(input);
        return scanner.nextLine();
    }

    public static void displayClothesOptions(){
        System.out.println("\nWhat item do you want to add?");
        System.out.println("1. Pants\n2. T-Shirt\n3. Skirt");
    }

    public static void displayOrderDoneOptions(){
        System.out.println("Order done?");
        System.out.println("1. Yes\n2. No");
    }

    public static void displayCustomerName(String name){
        System.out.println("Nice to meet you " + name);
    }

    public static void displayReceipt(Receipt receipt){
        receipt.printOrder();
    }

    /*public static int displayEnumChoices(String[] choices, String type) {

        System.out.println("["+type.toUpperCase()+"]");
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ". " + choices[i]);
        }

        return Controller.getValidChoice(choices.length);

    }*/

    public static int displayEnumChoices(List<String > choices, String type) {

        System.out.println("["+type.toUpperCase()+"]");
        for (int i = 0; i < choices.size(); i++) {
            System.out.println((i + 1) + ". " + choices.get(i));
        }

        return Controller.getValidChoice(choices.size());

    }

    public static String[] displayObjectSpecificAttribute(String titel, String text){

        String[] textArray = text.split("/");
        int nr = 1;

        System.out.println("["+titel.toUpperCase()+"] ");
        for (String string : textArray) {
            System.out.println(nr + ". " + string);
            nr++;
        }
        return textArray;
    }

}
