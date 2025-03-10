package com.example.Model.BusinessObjects;

import com.example.Model.BusinessObjects.Clothes.Pants;
import com.example.Model.BusinessObjects.Clothes.Skirt;
import com.example.Model.BusinessObjects.Clothes.TShirt;

import java.text.NumberFormat;

public class Receipt extends BusinessObject {

    private Order order;

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
            System.out.println("\t"+order.getClothesList().get(i).getSize());
            System.out.println("\t"+order.getClothesList().get(i).getMaterial());
            System.out.println("\t"+order.getClothesList().get(i).getColor());


            if(order.getClothesList().get(i) instanceof Pants){
                System.out.println("\t"+((Pants) order.getClothesList().get(i)).getFit());
                System.out.println("\t"+((Pants) order.getClothesList().get(i)).getLength());

            } else if (order.getClothesList().get(i) instanceof TShirt) {
                System.out.println("\t"+((TShirt) order.getClothesList().get(i)).getSleeves());
                System.out.println("\t"+((TShirt) order.getClothesList().get(i)).getNeck());

            } else if (order.getClothesList().get(i) instanceof Skirt) {
                System.out.println("\t"+((Skirt) order.getClothesList().get(i)).getWaistline());
                System.out.println("\t"+((Skirt) order.getClothesList().get(i)).getPattern());

            }else {
                System.out.println("Clothing type not added in Receipt print");
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

    @Override
    public String toString() {
        return "Receipt{" +
                "order=" + order +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
}
