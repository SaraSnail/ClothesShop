package com.example.View;

import com.example.Controller.*;
import com.example.Controller.Builder.PantsBuilder;
import com.example.Controller.Builder.SkirtBuilder;
import com.example.Controller.Builder.TShirtBuilder;
import com.example.Controller.Command.CommandPipeline;
import com.example.Controller.Command.PantsCommand;
import com.example.Controller.Command.SkirtCommand;
import com.example.Controller.Command.TShirtCommand;
import com.example.Controller.Enums.Color;
import com.example.Controller.Enums.Material;
import com.example.Controller.Enums.Size;
import com.example.Controller.Observer.EventManager;
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

    private static PantsCommand pantsCommand;
    private static TShirtCommand tShirtCommand;
    private static SkirtCommand skirtCommand;
    private static EventManager eventManager = new EventManager();

    public static void main(String[] args) {

        CEO ceo = new CEO(1,"Josefin Flodin");
        eventManager.addListener(ceo);

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


        order.setId(id);
        order.setCustomer(customer);
        System.out.println("Nice to meet you " + fullName);


        boolean addClothes = true;
        int clothesId = 1;

        while(addClothes) {

            System.out.println("\nWhat item do you want to add?");
            System.out.println("1. Pants\n2. T-Shirt\n3. Skirt");


            int clothesType = Util.getValidChoice(3);
            createClothes(clothesType, order, clothesId);
            clothesId++;


            System.out.println("Order done?");
            System.out.println("1. Yes\n2. No");
            int YN = Util.getValidChoice(2);
            switch (YN){
                case 1:
                    addClothes = false;
                    break;
                case 2:
                    break;

            }


        }


        Receipt receipt = new Receipt();
        receipt.setId(id);
        receipt.setOrder(order);
        receipt.printOrder();



    }

    private static void createClothes(int clothesType, Order order, int id){
        Size size;
        Material material;
        Color color;

        switch (clothesType){
            case 1:
                //Pants
                eventManager.notifyListeners("Starting to create pants");

                PantsBuilder pantsBuilder = new PantsBuilder();

                size = Size.fromValue(chooseEnum(sizes,"size"));
                material = Material.fromValue(chooseEnum(materials,"material"));
                color = Color.fromValue(chooseEnum(colors,"color"));

                Pants pants = pantsBuilder
                        .addSize(size)
                        .addMaterial(material)
                        .addColor(color)
                        .build();


                /*Pants pants = pantsBuilder
                        .addSize(Size.fromValue(chooseEnum(sizes,"size")))
                        .addMaterial(Material.fromValue(chooseEnum(materials,"material")))
                        .addColor(Color.fromValue(chooseEnum(colors,"color")))
                        .build();*/


                CommandPipeline pantsPipeline = new CommandPipeline();
                if(pantsCommand == null){
                    pantsCommand = new PantsCommand();
                    pantsPipeline.addCommand(pantsCommand);
                }

                pants = (Pants) pantsPipeline.execute(pants);

                pants.setId(id);

                eventManager.notifyListeners("Pants created");
                order.getClothesList().add(pants);

                break;
            case 2:
                //TShirt
                eventManager.notifyListeners("Starting to create a t-shirt");
                TShirtBuilder tShirtBuilder = new TShirtBuilder();

                size = Size.fromValue(chooseEnum(sizes,"size"));
                material = Material.fromValue(chooseEnum(materials,"material"));
                color = Color.fromValue(chooseEnum(colors,"color"));

                TShirt tShirt = tShirtBuilder
                        .addSize(size)
                        .addMaterial(material)
                        .addColor(color)
                        .build();




                CommandPipeline tShirtPipeline = new CommandPipeline();
                if(tShirtCommand == null){
                    tShirtCommand = new TShirtCommand();
                    tShirtPipeline.addCommand(tShirtCommand);
                }

                tShirt = (TShirt) tShirtPipeline.execute(tShirt);

                tShirt.setId(id);
                eventManager.notifyListeners("T-Shirt created");
                order.getClothesList().add(tShirt);
                break;

            case 3:
                //Skirt
                eventManager.notifyListeners("Starting to create a skirt");
                SkirtBuilder skirtBuilder = new SkirtBuilder();
                size = Size.fromValue(chooseEnum(sizes,"size"));
                material = Material.fromValue(chooseEnum(materials,"material"));
                color = Color.fromValue(chooseEnum(colors,"color"));


                Skirt skirt = skirtBuilder
                        .addSize(size)
                        .addMaterial(material)
                        .addColor(color)
                        .build();



                //Lyssnar när tex Pants skapas och när den läggs in i order lístan
                //Observer: objekt (ex ObserverHandler) som innehåller lista med objekt som är lyssnare. Har metod "notify" för att meddela dem.
                    //Kan ignorera old value
                //Kan ha true = börja tillverkas
                //false = plagg klart

                CommandPipeline skirtPipeline = new CommandPipeline();
                if(skirtCommand == null){
                    skirtCommand = new SkirtCommand();
                    skirtPipeline.addCommand(skirtCommand);
                }

                skirt = (Skirt) skirtPipeline.execute(skirt);

                skirt.setId(id);
                eventManager.notifyListeners("Skirt created");
                order.getClothesList().add(skirt);
                break;
            default:
                System.out.println("Invalid choice");

        }
    }

    private static int chooseEnum(String[] choices, String type) {

        System.out.println("["+type.toUpperCase()+"]");
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ". " + choices[i]);
        }

        while (true){

            int choice = Util.getValidChoice(3);

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

    }

}
