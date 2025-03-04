package com.example.Controller;


import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private String news;
    private List<Worker> listeners = new ArrayList<>();

    public EventManager() {

    }

    public void addListener(Worker listener) {
        listeners.add(listener);
    }

    public void removeListener(Worker listener) {
        listeners.remove(listener);
    }

    public void notifyListeners(String news) {
        this.news = news;
        for (Worker listener : listeners) {
            listener.update(this.news);
        }
    }
}
