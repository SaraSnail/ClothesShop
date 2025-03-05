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

    public void printOrder(){
        double total = 0;
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);

        System.out.println("\n------------------------");
        System.out.println("\t\t"+this.name + this.id);
        System.out.println("To: " + order.getCustomer().getMail());
        System.out.println(order.getCustomer().getName());
        System.out.println("------------------------");
        System.out.println("\t\t"+order.getName()+" "+ order.getId());
        System.out.println("------------------------");
        for (int i = 0; i < order.getClothesList().size(); i++) {


            System.out.println("\t\tGarment " + order.getClothesList().get(i).getId());
            System.out.println(order.getClothesList().get(i).getName());
            /*System.out.println("\t"+order.getClothesList().get(i).getColor().toString().toLowerCase());
            System.out.println("\t"+order.getClothesList().get(i).getSize().toString().toLowerCase());
            System.out.println("\t"+order.getClothesList().get(i).getMaterial().toString().toLowerCase());*/

            System.out.println("\t"+order.getClothesList().get(i).getColor());
            System.out.println("\t"+order.getClothesList().get(i).getSize());
            System.out.println("\t"+order.getClothesList().get(i).getMaterial());

            if(order.getClothesList().get(i).getName().equals("Pants")){
                //Kan få de specifika för de sortens plagg
                Pants pants = (Pants)order.getClothesList().get(i);
                //System.out.println("\t"+pants.getFit().toLowerCase());
                System.out.println("\t"+pants.getFit());
                System.out.println("\t"+pants.getLength());

            } else if (order.getClothesList().get(i).getName().equals("T-Shirt")) {
                TShirt tShirt = (TShirt)order.getClothesList().get(i);
                System.out.println("\t"+tShirt.getSleeves());
                System.out.println("\t"+tShirt.getNeck());

            }else if(order.getClothesList().get(i).getName().equals("Skirt")){
                Skirt skirt = (Skirt)order.getClothesList().get(i);
                System.out.println("\t"+skirt.getWaistline());
                System.out.println("\t"+skirt.getPattern());
            }

            System.out.println("\t\t\t"+order.getClothesList().get(i).getPrice() + " kr");
            total += order.getClothesList().get(i).getPrice();
            System.out.println("\n------------------------");
        }
        System.out.println("TOTAL: " +numberFormat.format(total)+" kr");
        System.out.println();
        System.out.println("Sent to adress: " + order.getCustomer().getAdress());
        System.out.println("Thanks for shopping!");
        System.out.println("\n------------------------");
    }

    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
}
