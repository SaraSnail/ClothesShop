package com.example.Model.BusinessObjects;

import java.util.ArrayList;
import java.util.List;

public class Customer extends BusinessObject{
    private String adress;
    private String mail;

    //private List<Order> orders = new ArrayList<Order>();//Ha flera orders eller en order med flera plagg?

    public Customer() {
    }

    public Customer(int id, String name, String adress, String mail) {
        super(id, name);
        this.adress = adress;
        this.mail = mail;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
