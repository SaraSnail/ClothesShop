package com.example.Model.BusinessObjects;


public class Customer extends BusinessObject {
    private String adress;
    private String mail;

    public Customer() {

    }

    public Customer(int id, String name, String adress, String mail) {
        super(id, name);
        this.adress = adress;
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "mail='" + mail + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                '}';
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
