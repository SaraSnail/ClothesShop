package com.example;

import com.example.Controller.*;
import com.example.Model.BusinessObjects.CEO;
import com.example.Model.BusinessObjects.Clothes.Pants;
import com.example.Model.BusinessObjects.Clothes.TShirt;
import com.example.Model.BusinessObjects.Customer;
import com.example.Model.BusinessObjects.Order;
import com.example.Model.BusinessObjects.Receipt;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    private static String[] sizes = {String.valueOf(Size.fromValue(1)),String.valueOf(Size.fromValue(2)),String.valueOf(Size.fromValue(3))};
    private static String[] materials = {String.valueOf(Material.fromValue(1)),String.valueOf(Material.fromValue(2)),String.valueOf(Material.fromValue(3))};
    private static String[] colors = {String.valueOf(Color.fromValue(1)),String.valueOf(Color.fromValue(2)),String.valueOf(Color.fromValue(3))};

    public static void main( String[] args )
    {

        CEO ceo = new CEO(2,"Keigo Takami");

        Customer customer1 = new Customer(1,"Julia Skog","Luthagen 12B","juliaSkog@gmail.com");
        orderLoop(customer1,ceo,1);

        System.out.println("---------:3--------");


        /*PantsBuilder builder = new PantsBuilder();

        Pants pants = builder
                .addColor(Color.fromValue(3))
                .addMaterial(Material.fromValue(1))
                .addSize(Size.fromValue(1))
                .build();

        pants.setId(1);
        pants.setName("Pants");
        System.out.println(pants.getMaterial() + "\n" + pants.getColor() + "\n" + pants.getSize() );


        System.out.println("----------------------------");

        String[] sizes = {"Small","Medium","Large"};
        int sizeChoice = chooseEnum(sizes,"size");
        System.out.println("Choice = " + Size.fromValue(sizeChoice));

        String[] materials = {"Cotton","Polyester","Jeans"};
        int materialChoice = chooseEnum(materials,"material");
        System.out.println("Choice = " + Material.fromValue(materialChoice));

        String[] colors = {"Black","White","Blue"};
        int colorChoice = chooseEnum(colors,"color");
        System.out.println("Choice = " + Color.fromValue(colorChoice));

        PantsBuilder pantsBuilder = new PantsBuilder();

        Pants pants1 = pantsBuilder
                .addSize(Size.fromValue(sizeChoice))
                .addColor(Color.fromValue(colorChoice))
                .addMaterial(Material.fromValue(materialChoice))
                .build();

        pants1.setId(2);

        System.out.println(pants1.getSize() + "\n" + pants1.getColor() + "\n" + pants1.getMaterial() );

        Order order = new Order();
        Customer customer = new Customer(1,"Max","beep","mo@gmail.com");
        order.setCustomer(customer);
        order.setName("Order 1");
        order.getClothesList().add(pants);
        order.getClothesList().add(pants1);

        Receipt receipt = new Receipt();
        receipt.setOrder(order);
        receipt.printOrder();*/

    }

    private static int chooseEnum(String[] choices, String type) {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        System.out.println("["+type.toUpperCase()+"]");
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ". " + choices[i]);
        }

        while (loop){
            System.out.print("Enter choice: ");
            String material = scanner.nextLine();
            try {
                int choice = Integer.parseInt(material);
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
            }catch (NumberFormatException e){
                System.out.println("Invalid choice");
            }
        }

        return 0;

    }

    private static void orderLoop(Customer customer, CEO ceo,int id){
        int start = 1;
        Scanner scanner = new Scanner(System.in);

        Order order = new Order();
        order.addPropertyChangeListener(ceo);

        order.setOrderDone(false);//Varför skrivs inte CEO's listener ut på denna?
        order.setCustomer(customer);//CEO lyssnar och skriver ut "Customer order started"
        order.setName("Order from " + customer.getName());
        order.setId(id);

        /*String[] sizes = {String.valueOf(Size.fromValue(1)),String.valueOf(Size.fromValue(2)),String.valueOf(Size.fromValue(3))};
        String[] materials = {String.valueOf(Material.fromValue(1)),String.valueOf(Material.fromValue(2)),String.valueOf(Material.fromValue(3))};
        String[] colors = {String.valueOf(Color.fromValue(1)),String.valueOf(Color.fromValue(2)),String.valueOf(Color.fromValue(3))};*/

        boolean loop = true;

        while(loop) {
            System.out.println("Nr:" + start);
            System.out.println("1. Pants\n2.T-Shirt");
            boolean loop3 = true;
            while (loop3) {

                System.out.print("Enter choice: ");
                String choice = scanner.nextLine();
                try {
                    int nrChoice = Integer.parseInt(choice);
                    createClothes(nrChoice, start, order);
                    loop3 = false;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid choice");
                }
            }

            /*int sizeChoice = chooseEnum(sizes,"size");
            int materialChoice = chooseEnum(materials,"material");
            int colorChoice = chooseEnum(colors,"color");

            PantsBuilder pantsBuilder = new PantsBuilder();
            Pants pants = pantsBuilder
                    .addSize(Size.fromValue(sizeChoice))
                    .addColor(Color.fromValue(colorChoice))
                    .addMaterial(Material.fromValue(materialChoice))
                    .build();

            pants.setId(start);
            order.getClothesList().add(pants);*/

            boolean loop2 = true;

            while(loop2) {
                System.out.println("Order done? \n1.yes \n2.no");
                System.out.print("Enter: ");
                String yesOrNo = scanner.nextLine();
                try {
                    int OneOrTwo = Integer.parseInt(yesOrNo);
                    switch (OneOrTwo) {
                        case 1:
                            order.setOrderDone(true);
                            loop = false;
                            loop2 = false;
                            break;
                        case 2:

                            start++;
                            System.out.println("Another order");
                            loop2 = false;
                            break;

                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid choice");
                }
            }

        }

        Receipt receipt = new Receipt();
        receipt.setOrder(order);
        receipt.setId(id);
        receipt.printOrder();

    }

    private static void createClothes(int type, int id,Order order){
        int sizeChoice;
        int materialChoice;
        int colorChoice;

        switch (type){
            case 1:
                //Pants
                sizeChoice = chooseEnum(sizes,"size");
                materialChoice = chooseEnum(materials,"material");
                colorChoice = chooseEnum(colors,"color");

                PantsBuilder pantsBuilder = new PantsBuilder();
                Pants pants = pantsBuilder
                        .addSize(Size.fromValue(sizeChoice))
                        .addColor(Color.fromValue(colorChoice))
                        .addMaterial(Material.fromValue(materialChoice))
                        .build();

                pants.setId(id);
                order.getClothesList().add(pants);

                break;
            case 2:
                //TShirt
                sizeChoice = chooseEnum(sizes,"size");
                materialChoice = chooseEnum(materials,"material");
                colorChoice = chooseEnum(colors,"color");

                TShirtBuilder tShirtBuilder = new TShirtBuilder();
                TShirt tShirt = tShirtBuilder
                        .addSize(Size.fromValue(sizeChoice))
                        .addColor(Color.fromValue(colorChoice))
                        .addMaterial(Material.fromValue(materialChoice))
                        .build();

                tShirt.setId(id);
                order.getClothesList().add(tShirt);
                break;
            case 3:
                //Skirt
                break;
            default:

                break;
        }
    }

}
