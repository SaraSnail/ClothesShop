package com.example;

import com.example.Controller.MenuController;
import com.example.Model.BusinessObjects.Customer;
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
            MenuView.customerExample();

            String fullName = MenuController.userInputCorrect("Full name: ");
            String address = MenuController.userInputCorrect("Address: ");
            String mail = MenuController.userInputCorrect("Mail: ");

            Customer customer = MenuController.createCustomer(id, fullName, address, mail);
            Order order = MenuController.createOrder(id, customer);

            MenuView.displayCustomerName(customer.getName());

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
                MenuView.displayQuit();
            }

        }
    }
}
