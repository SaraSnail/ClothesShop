package com.example;

import com.example.Controller.MenuController;
import com.example.Model.BusinessObjects.Order;
import com.example.Model.BusinessObjects.Receipt;
import com.example.View.MenuView;


public class Menu {

    public static void main(String[] args) {
        MenuController.createCEO();
        MenuView.displayWelcomeMessage();

        String fullName = MenuView.getUserInput("Full name: ");
        String address = MenuView.getUserInput("Address: ");
        String mail = MenuView.getUserInput("Mail: ");

        int id = 1;
        Order order = MenuController.createCustomerAndOrder(id,fullName,address,mail);

        MenuView.displayCustomerName(order.getCustomer().getName());

        boolean addClothes = true;
        int clothesId = 1;

        MenuController.enumValuesToString();

        while(addClothes) {

            MenuView.displayClothesOptions();

            int clothesType = MenuController.getValidChoice(3);
            MenuController.createClothes(clothesType, order, clothesId);
            clothesId++;


            MenuView.displayOrderDoneOptions();
            int YN = MenuController.getValidChoice(2);

            if(YN == 1){
                addClothes = false;
            }

        }

        Receipt receipt = MenuController.createReceipt(id,order);
        MenuView.displayReceipt(receipt);
    }
}
