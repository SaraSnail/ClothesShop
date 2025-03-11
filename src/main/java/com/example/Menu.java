package com.example;

import com.example.Controller.MenuController;
import com.example.Model.BusinessObjects.Order;
import com.example.Model.BusinessObjects.Receipt;
import com.example.View.MenuView;


public class Menu {

    private static int choice;
    private static int id;

    public static void main(String[] args) {
        MenuController.createCEO();
        MenuController.enumValuesToString();

        choice = 1;
        id = 1;

        while (choice == 1) {

            MenuView.displayWelcomeMessage();

            String fullName = MenuView.getUserInput("Full name: ");
            String address = MenuView.getUserInput("Address: ");
            String mail = MenuView.getUserInput("Mail: ");

            Order order = MenuController.createCustomerAndOrder(id, fullName, address, mail);

            MenuView.displayCustomerName(order.getCustomer().getName());

            boolean addClothes = true;
            int clothesId = 1;



            while (addClothes) {

                MenuView.displayClothesOptions();

                int clothesType = MenuController.getValidChoice(3);
                MenuController.createClothes(clothesType, order, clothesId);
                clothesId++;


                MenuView.displayOrderDoneOptions();
                int YN = MenuController.getValidChoice(2);

                if (YN == 1) {
                    addClothes = false;
                }

            }

            Receipt receipt = MenuController.createReceipt(id, order);
            MenuView.displayReceipt(receipt);

            MenuView.moreCustomers();
            choice = MenuController.getValidChoice(2);

            if (choice == 1) {
                id++;
                System.out.println();
            }else {
                System.out.println("Shutting down...");
            }

        }
    }
}
