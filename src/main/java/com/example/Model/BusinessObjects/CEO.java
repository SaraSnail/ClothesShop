package com.example.Model.BusinessObjects;

import com.example.Controller.Observer.Worker;

public class CEO extends BusinessObject implements Worker {//implements PropertyChangeListener
    //Observer: ska notifieras när kläder beställts osv


    public CEO() {
    }

    public CEO(int id, String name) {
        super(id, name);
    }

    /*@Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println(evt.getPropertyName() + ": " + evt.getOldValue() + " -> " + evt.getNewValue());
        *//*if(evt.getOldValue().equals(String.valueOf("Working")) && evt.getNewValue().equals(String.valueOf("Done"))) {
            System.out.println(evt.getPropertyName() + " finished");
        }*//*
    }*/

    @Override
    public void update(String news){
        System.out.println("CEO got the news: " + news);
        //https://www.baeldung.com/java-observer-pattern
    }


}
