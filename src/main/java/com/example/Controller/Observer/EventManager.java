package com.example.Controller.Observer;


import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private String news;
    private List<Worker> listeners = new ArrayList<>();
    private static EventManager instance;

    public static EventManager getInstance() {
        if (instance == null) {
            instance = new EventManager();
        }
        return instance;
    }

    private EventManager() {

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
