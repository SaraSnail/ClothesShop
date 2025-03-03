package com.example.Model.BusinessObjects;

import com.example.Model.BusinessObjects.Clothes.Clothes;
import com.example.Model.BusinessObjects.Clothes.Pants;
import com.example.Model.BusinessObjects.Clothes.Skirt;
import com.example.Model.BusinessObjects.Clothes.TShirt;

import java.text.NumberFormat;

public class Receipt extends BusinessObject{
    //Skriva ut order snyggt
    private Order order;//För flera ordrar kanske ta in en List<Order>orders?

    public Receipt() {
        this.name = "Receipt";
    }

    public Receipt(int id, String name, Order order) {
        super(id, name);
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }

    public void printOrder(){
        double total = 0;
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);

        System.out.println(this.id);
        System.out.println("To: " + order.getCustomer().getMail());
        System.out.println("----------"+order.getName()+"----------");
        System.out.println("----------"+order.getId()+"----------");
        System.out.println("----------"+order.getCustomer().getName()+"----------");
        for (int i = 0; i < order.getClothesList().size(); i++) {


            System.out.println(order.getClothesList().get(i).getName() +" " + order.getClothesList().get(i).getId());
            System.out.println(order.getClothesList().get(i).getColor());
            System.out.println(order.getClothesList().get(i).getSize());
            System.out.println(order.getClothesList().get(i).getMaterial());

            if(order.getClothesList().get(i).getName().equals("Pants")){
                //Kan få de specifika för de sortens plagg
                Pants pants = (Pants)order.getClothesList().get(i);
                System.out.println(pants.getFit());
                System.out.println(pants.getLength());
            } else if (order.getClothesList().get(i).getName().equals("T-Shirt")) {
                TShirt tShirt = (TShirt)order.getClothesList().get(i);
                System.out.println(tShirt.getSleeves());
                System.out.println(tShirt.getNeck());

            }else if(order.getClothesList().get(i).getName().equals("Skirt")){
                Skirt skirt = (Skirt)order.getClothesList().get(i);
                System.out.println(skirt.getWaistline());
                System.out.println(skirt.getPattern());
            }

            System.out.println(order.getClothesList().get(i).getPrice() + " kr");
            total += order.getClothesList().get(i).getPrice();
            System.out.println("------------------------");
        }
        System.out.println("Total: " +numberFormat.format(total)+" kr");

        System.out.println("Sent to adress: " + order.getCustomer().getAdress());
        System.out.println("Thanks for shopping!");
    }
}
