package edu.etu.web;

/**
 * Created by Алексей on 25.03.2015.
 */
public class Item {
    public String id;
    public String title;
    public Double price;
    public String briefDescription;
    public String fullDescription;

    public Item(String id, String title, Double price, String briefDescription, String fullDescription) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.briefDescription = briefDescription;
        this.fullDescription = fullDescription;
    }

    public Double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getBriefDescription() {
        return briefDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }
}
