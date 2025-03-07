package com.example.Controller.Observer;


import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private String news;
    private List<Listener> listeners = new ArrayList<>();
    private static EventManager instance;

    public static EventManager getInstance() {
        if (instance == null) {
            instance = new EventManager();
        }
        return instance;
    }

    private EventManager() {

    }

    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    public void removeListener(Listener listener) {
        listeners.remove(listener);
    }

    public void notifyListeners(String news) {
        this.news = news;
        for (Listener listener : listeners) {
            System.out.println();
            listener.update(this.news);
            System.out.println();
        }
    }


}
