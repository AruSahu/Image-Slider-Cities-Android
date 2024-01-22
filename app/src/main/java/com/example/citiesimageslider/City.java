package com.example.citiesimageslider;

import java.util.ArrayList;

public class City {
    private String name;
    private ArrayList <String> imageURLs;

    public City(String name, ArrayList<String> imageURLs) {
        this.name = name;
        this.imageURLs = imageURLs;
    }

    public City() {
        imageURLs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getImageURLs() {
        return imageURLs;
    }

    public void setImageURLs(ArrayList<String> imageURLs) {
        this.imageURLs = imageURLs;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", imageURLs=" + imageURLs +
                '}';
    }
}
