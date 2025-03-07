package com.example.Model.BusinessObjects;

import com.example.Controller.Observer.Listener;

public class CEO extends BusinessObject implements Listener {
    private String news;

    public CEO() {
    }

    public CEO(int id, String name) {
        super(id, name);
    }


    @Override
    public void update(Object news){
        this.setNews((String)news);
        System.out.println(this.name +" got the news: " + news);

    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }
}
