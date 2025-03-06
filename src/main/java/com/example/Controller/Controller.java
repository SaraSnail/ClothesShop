package com.example.Controller;

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
import com.example.View.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
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
        int choice = -1;
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
        CEO ceo = new CEO(1,"Josefin Flodin");
        eventManager.addListener(ceo);
    }

    public static Order createCustomerAndOrder(int id,String fullName,String adress,String mail){
        Customer customer = new Customer(id,fullName,adress,mail);
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

        Size size = Size.fromValue(View.displayEnumChoices(sizesList,"size"));
        Material material = Material.fromValue(View.displayEnumChoices(materialList,"material"));
        Color color = Color.fromValue(View.displayEnumChoices(colorList,"color"));

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

        Size size = Size.fromValue(View.displayEnumChoices(sizesList,"size"));
        Material material = Material.fromValue(View.displayEnumChoices(materialList,"material"));
        Color color = Color.fromValue(View.displayEnumChoices(colorList,"color"));

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
        Size size = Size.fromValue(View.displayEnumChoices(sizesList,"size"));
        Material material = Material.fromValue(View.displayEnumChoices(materialList,"material"));
        Color color = Color.fromValue(View.displayEnumChoices(colorList,"color"));


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
        String[] choices = View.displayObjectSpecificAttribute(titel, text);
        int nrChoice = getValidChoice(choices.length);
        return choices[nrChoice -1].toUpperCase();
    }


}
