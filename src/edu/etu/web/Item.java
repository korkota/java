package edu.etu.web;

/**
 * Created by Алексей on 25.03.2015.
 */
public class Item {
    public String id;
    public String title;
    public String price;
    public String briefDescription;
    public String fullDescription;

    public Item(String id, String title, String price, String briefDescription, String fullDescription) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.briefDescription = briefDescription;
        this.fullDescription = fullDescription;
    }
}
