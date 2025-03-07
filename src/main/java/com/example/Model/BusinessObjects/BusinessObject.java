package com.example.Model.BusinessObjects;

public abstract class BusinessObject {
    protected int id;
    protected String name;

    public BusinessObject() {
    }


    public BusinessObject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "BusinessObject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public BusinessObject(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
