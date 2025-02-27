package com.example.Model.BusinessObjects;

import com.example.Model.BusinessObjects.Clothes.Clothes;

import java.util.ArrayList;
import java.util.List;

public class Order extends BusinessObject{

    private List<Clothes> clothesList = new ArrayList<>();//Ha flera orders eller en order med flera plagg?
    private Customer customer;

    public Order() {
    }

    public Order(int id, String name) {
        super(id, name);
    }

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
        this.customer = customer;
    }
}
