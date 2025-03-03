package com.example.Controller;

import java.util.Scanner;

public class Util {
    private static Scanner scanner = new Scanner(System.in);

    public static int getValidChoice(int maxOptions){
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
    }
}
