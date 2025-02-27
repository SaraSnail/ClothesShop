package com.example.Model.BusinessObjects;

public class Receipt extends BusinessObject{
    //Skriva ut order snyggt
    private Order order;//För flera ordrar kanske ta in en List<Order>orders?

    public Receipt() {
    }

    public Receipt(int id, String name,Order order) {
        super(id, name);
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void printOrder(){
        System.out.println("To: " + order.getCustomer().getMail());
        System.out.println("----------"+order.getName()+"----------");
        System.out.println("----------"+order.getCustomer().getName()+"----------");
        System.out.println("------------------------");
        for (int i = 0; i < order.getClothesList().size(); i++) {
            System.out.println(order.getClothesList().get(i).getName() + order.getClothesList().get(i).getId());
            System.out.println(order.getClothesList().get(i).getColor());
            System.out.println(order.getClothesList().get(i).getMaterial());
            System.out.println(order.getClothesList().get(i).getPrice());
            System.out.println("------------------------");
        }

        System.out.println("Sent to adress: " + order.getCustomer().getAdress());
        System.out.println("Thanks for shopping!");
    }
}
