package com.example.Model.BusinessObjects;

import com.example.Model.BusinessObjects.Clothes.Clothes;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Order extends BusinessObject{

    private List<Clothes> clothesList = new ArrayList<>();//Ha flera orders eller en order med flera plagg?
    private Customer customer;
    //private PropertyChangeSupport propertyChangeSupport;//CEO lyssna här eller annan plats, eller lyssna här och på receipt?
    //private boolean orderDone = false;

    public Order() {
        this.name = "Order";
        //propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public Order(int id, String name) {
        super(id, name);
        //propertyChangeSupport = new PropertyChangeSupport(this);
    }

    /*public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }*/

    public List<Clothes> getClothesList() {
        return clothesList;
    }

    public void setClothesList(List<Clothes> clothesList) {
        this.clothesList = clothesList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        //Customer oldCustomer = this.customer;
        this.customer = customer;
        /*if (oldCustomer == null) {
            propertyChangeSupport.firePropertyChange("Customer started order", null, this.customer.getName());
        }else {
            propertyChangeSupport.firePropertyChange("Customer started order", oldCustomer.getName(), this.customer.getName());
        }*/
    }

    /*public boolean isOrderDone() {
        return orderDone;
    }

    public void setOrderDone(boolean orderDone) {
        //boolean oldOrderDone = this.orderDone;
        this.orderDone = orderDone;
        //propertyChangeSupport.firePropertyChange("Order done status changed", oldOrderDone, this.orderDone);
    }*/
}
