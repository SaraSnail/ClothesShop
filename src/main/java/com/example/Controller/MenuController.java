package com.example.Controller;

import com.example.Model.Builder.PantsBuilder;
import com.example.Model.Builder.SkirtBuilder;
import com.example.Model.Builder.TShirtBuilder;
import com.example.Controller.Command.CommandPipeline;
import com.example.Controller.Command.PantsCommand;
import com.example.Controller.Command.SkirtCommand;
import com.example.Controller.Command.TShirtCommand;
import com.example.Model.Enums.Color;
import com.example.Model.Enums.Material;
import com.example.Model.Enums.Size;
import com.example.Model.Observer.EventManager;
import com.example.Model.BusinessObjects.CEO;
import com.example.Model.BusinessObjects.Clothes.Pants;
import com.example.Model.BusinessObjects.Clothes.Skirt;
import com.example.Model.BusinessObjects.Clothes.TShirt;
import com.example.Model.BusinessObjects.Customer;
import com.example.Model.BusinessObjects.Order;
import com.example.Model.BusinessObjects.Receipt;
import com.example.View.MenuView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuController {
    private static Scanner scanner = new Scanner(System.in);

    private static List<String> sizesList = new ArrayList<>();
    private static List<String> materialList = new ArrayList<>();
    private static List<String> colorList = new ArrayList<>();
    private static EventManager eventManager = EventManager.getInstance();

    private static void sizeToStringList() {
        for(Size size : Size.values()) {
            sizesList.add(size.toString());
        }
    }

    private static void materialToStringList() {
        for(Material material : Material.values()) {
            materialList.add(material.toString());
        }
    }

    private static void colorToStringList() {
        for(Color color : Color.values()) {
            colorList.add(color.toString());
        }
    }

    public static void enumValuesToString(){
        sizeToStringList();
        materialToStringList();
        colorToStringList();
    }

    public static int getValidChoice(int maxOptions){
        int choice = 0;
        while(choice < 1 || choice > maxOptions){
            try{
                System.out.print("Enter your choice: ");
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

    public static void createCEO(){
        CEO ceo = new CEO(1,"Tomas Wigell");
        eventManager.addListener(ceo);
    }

    public static Customer createCustomer(int id,String fullName,String adress,String mail){
        return new Customer(id,fullName,adress,mail);
    }

    public static Order createOrder(int id, Customer customer){
        Order order = new Order(id,"Order");
        order.setCustomer(customer);
        return order;
    }

    public static Receipt createReceipt(int id, Order order){
        Receipt receipt = new Receipt();
        receipt.setId(id);
        receipt.setOrder(order);
        return receipt;
    }

    public static void createClothes(int clothesType, Order order, int id){

        switch (clothesType){
            case 1:
                //Pants
                createPants(order, id);

                break;
            case 2:
                //TShirt
                createTShirt(order, id);

                break;

            case 3:
                //Skirt
                createSkirt(order, id);

                break;
            default:
                System.out.println("Invalid choice");

        }
    }

    private static void createPants(Order order,int id){
        PantsBuilder pantsBuilder = new PantsBuilder();

        Size size = Size.fromValue(MenuView.displayEnumChoices(sizesList,"size"));
        Material material = Material.fromValue(MenuView.displayEnumChoices(materialList,"material"));
        Color color = Color.fromValue(MenuView.displayEnumChoices(colorList,"color"));

        Pants pants = (Pants) pantsBuilder
                .addSize(size)
                .addMaterial(material)
                .addColor(color)
                .build();

        String fit = attributeChoice("Fit","Loose/Tight");
        String length = attributeChoice("Length","Short/Long");

        CommandPipeline pantsPipeline = new CommandPipeline();
        pantsPipeline.addCommand(new PantsCommand(fit,length));

        pants = (Pants) pantsPipeline.execute(pants);

        pants.setId(id);
        order.getClothesList().add(pants);
    }

    private static void createTShirt(Order order,int id){
        TShirtBuilder tShirtBuilder = new TShirtBuilder();

        Size size = Size.fromValue(MenuView.displayEnumChoices(sizesList,"size"));
        Material material = Material.fromValue(MenuView.displayEnumChoices(materialList,"material"));
        Color color = Color.fromValue(MenuView.displayEnumChoices(colorList,"color"));

        TShirt tShirt = (TShirt) tShirtBuilder
                .addSize(size)
                .addMaterial(material)
                .addColor(color)
                .build();


        String neck = attributeChoice("Neck","Circle/V");
        String sleeves = attributeChoice("Sleeves","Long/Short");

        CommandPipeline tShirtPipeline = new CommandPipeline();
        tShirtPipeline.addCommand(new TShirtCommand(neck,sleeves));

        tShirt = (TShirt) tShirtPipeline.execute(tShirt);

        tShirt.setId(id);
        order.getClothesList().add(tShirt);
    }

    private static void createSkirt(Order order,int id){
        SkirtBuilder skirtBuilder = new SkirtBuilder();
        Size size = Size.fromValue(MenuView.displayEnumChoices(sizesList,"size"));
        Material material = Material.fromValue(MenuView.displayEnumChoices(materialList,"material"));
        Color color = Color.fromValue(MenuView.displayEnumChoices(colorList,"color"));


        Skirt skirt = (Skirt) skirtBuilder
                .addSize(size)
                .addMaterial(material)
                .addColor(color)
                .build();

        String waistline = attributeChoice("Waistline","Stretchy/Firm fit");
        String pattern = attributeChoice("Pattern", "Singular color/Striped");


        CommandPipeline skirtPipeline = new CommandPipeline();

        skirtPipeline.addCommand(new SkirtCommand(waistline,pattern));

        skirt = (Skirt) skirtPipeline.execute(skirt);

        skirt.setId(id);
        order.getClothesList().add(skirt);
    }

    private static String attributeChoice(String titel, String text){
        String[] choices = MenuView.displayObjectSpecificAttribute(titel, text);
        int nrChoice = getValidChoice(choices.length);
        return choices[nrChoice -1];
    }

    public static String userInputCorrect(String type){
        String input;
        String[] number = {"1","2","3","4","5","6","7","8","9"};

        switch (type) {
            case "Full name: ":
                while (true) {
                    input = MenuView.getUserInput(type);
                    if (input.contains(" ")) {
                        return input;
                    }else {
                        System.out.println("Must contain a space between first and last name");
                    }
                }
            case "Address: ":
                while (true) {
                    input = MenuView.getUserInput(type);
                    for(String nr : number){
                        if (input.contains(nr)) {
                            return input;
                        }
                    }
                    System.out.println("Must contain a house number");

                }

            case "Mail: ":
                while (true) {
                    input = MenuView.getUserInput(type);
                    if (input.contains("@")) {
                        return input;
                    }else {
                        System.out.println("Must contain a @ to be an email address");
                    }
                }
            default:
                System.out.println("Invalid choice");
        }
        return null;
    }

}
