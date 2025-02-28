package com.example.Model.BusinessObjects;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CEO extends BusinessObject implements PropertyChangeListener {
    //Observer: ska notifieras när kläder beställts osv

    public CEO() {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println(evt.getPropertyName() + ": " + evt.getOldValue() + " -> " + evt.getNewValue());
    }

    public CEO(int id, String name) {
        super(id, name);
    }
}
