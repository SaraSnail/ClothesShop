package com.example;

import com.example.Controller.Controller;
import com.example.Model.BusinessObjects.Order;
import com.example.Model.BusinessObjects.Receipt;
import com.example.View.View;


public class Meny {

    public static void main(String[] args) {
        Controller.createCEO();
        View.displayWelcomeMessage();

        String fullName = View.getUserInput("Full name: ");
        String address = View.getUserInput("Address: ");
        String mail = View.getUserInput("Mail: ");

        int id = 1;
        Order order = Controller.createCustomerAndOrder(id,fullName,address,mail);

        View.displayCustomerName(order.getCustomer().getName());

        boolean addClothes = true;
        int clothesId = 1;

        Controller.enumValuesToString();

        while(addClothes) {

            View.displayClothesOptions();

            int clothesType = Controller.getValidChoice(3);
            Controller.createClothes(clothesType, order, clothesId);
            clothesId++;


            View.displayOrderDoneOptions();
            int YN = Controller.getValidChoice(2);

            if(YN == 1){
                addClothes = false;
            }

        }

        Receipt receipt = Controller.createReceipt(id,order);
        View.displayReceipt(receipt);
    }
}
