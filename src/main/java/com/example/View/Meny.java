package com.example.View;

import com.example.Controller.*;
import com.example.Model.BusinessObjects.CEO;
import com.example.Model.BusinessObjects.Clothes.Pants;
import com.example.Model.BusinessObjects.Clothes.Skirt;
import com.example.Model.BusinessObjects.Clothes.TShirt;
import com.example.Model.BusinessObjects.Customer;
import com.example.Model.BusinessObjects.Order;
import com.example.Model.BusinessObjects.Receipt;

import java.util.Scanner;

public class Meny {
    private static String[] sizes = {String.valueOf(Size.fromValue(1)),String.valueOf(Size.fromValue(2)),String.valueOf(Size.fromValue(3))};
    private static String[] materials = {String.valueOf(Material.fromValue(1)),String.valueOf(Material.fromValue(2)),String.valueOf(Material.fromValue(3))};
    private static String[] colors = {String.valueOf(Color.fromValue(1)),String.valueOf(Color.fromValue(2)),String.valueOf(Color.fromValue(3))};
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        CEO ceo = new CEO(1,"Josefin Flodin");

        int id = 1;

        System.out.println("Welcome! Please enter the following materials:");
        System.out.print("Full name: ");
        String fullName = scanner.nextLine();
        System.out.print("Adress: ");
        String adress = scanner.nextLine();
        System.out.print("Mail: ");
        String mail = scanner.nextLine();
        Customer customer = new Customer(id,fullName,adress,mail);

        Order order = new Order();
        order.addPropertyChangeListener(ceo);

        order.setId(id);
        order.setCustomer(customer);
        order.setOrderDone(false);
        System.out.println("Nice to meet you " + fullName);


        boolean addClothes = true;
        int clothesId = 1;

        while(addClothes) {

            System.out.println("\nWhat item do you want to add?");
            System.out.println("1. Pants\n2. T-Shirt\n3. Skirt");
            System.out.print("Enter your choice: ");


            int clothesType = getValidChoice(3);
            createClothes(clothesType, order, clothesId);
            clothesId++;


            System.out.println("Order done?");
            System.out.println("1. Yes\n2. No");
            System.out.print("Enter your choice: ");
            int YN = getValidChoice(2);
            switch (YN){
                case 1:
                    order.setOrderDone(true);
                    addClothes = false;
                    break;
                case 2:
                    order.setOrderDone(false);
                    break;

            }


        }

        Receipt receipt = new Receipt();
        receipt.setOrder(order);
        receipt.printOrder();



    }

    private static void createClothes(int clothesType, Order order, int id){
        switch (clothesType){
            case 1:
                //Pants
                PantsBuilder pantsBuilder = new PantsBuilder();
                Pants pants = pantsBuilder
                        .addSize(Size.fromValue(chooseEnum(sizes,"size")))
                        .addMaterial(Material.fromValue(chooseEnum(materials,"material")))
                        .addColor(Color.fromValue(chooseEnum(colors,"color")))
                        .build();

                pants.setId(id);
                order.getClothesList().add(pants);

                break;
            case 2:
                //TShirt
                TShirtBuilder tShirtBuilder = new TShirtBuilder();
                TShirt tShirt = tShirtBuilder
                        .addSize(Size.fromValue(chooseEnum(sizes,"size")))
                        .addMaterial(Material.fromValue(chooseEnum(materials,"material")))
                        .addColor(Color.fromValue(chooseEnum(colors,"color")))
                        .build();

                tShirt.setId(id);
                order.getClothesList().add(tShirt);
                break;
            case 3:
                //Skirt
                SkirtBuilder skirtBuilder = new SkirtBuilder();
                Skirt skirt = skirtBuilder
                        .addSize(Size.fromValue(chooseEnum(sizes,"size")))
                        .addMaterial(Material.fromValue(chooseEnum(materials, "material")))
                        .addColor(Color.fromValue(chooseEnum(colors,"color")))
                        .build();
                skirt.setId(id);
                order.getClothesList().add(skirt);
                break;
            default:
                System.out.println("Invalid choice");

        }
    }

    private static int chooseEnum(String[] choices, String type) {
        boolean loop = true;

        System.out.println("["+type.toUpperCase()+"]");
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ". " + choices[i]);
        }

        while (loop){
            System.out.print("Enter choice: ");

            int choice = getValidChoice(3);
            switch (choice) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                default:
                    System.out.println("Invalid choice");
            }

        }

        return 0;

    }

    private static int getValidChoice(int maxOptions){
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
