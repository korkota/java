package edu.etu.web;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Алексей on 01.04.2015.
 */
public class Cart {
    private HashMap<Item, Integer> cart = new HashMap<Item, Integer>();

    public HashMap<Item, Integer> getCart () {
        return cart;
    }

    public void addItem(Item item, Integer count) {
        Integer value = cart.get(item);

        if (value != null) {
            count += value;
        }

        cart.put(item, count);
    }

    public void reset() {
        cart = new HashMap<Item, Integer>();
    }

    public double getTotalSum() {
        double total = 0.0;

        for (Map.Entry<Item, Integer> entry : cart.entrySet()) {
            total += entry.getKey().price * entry.getValue();
        }

        return total;
    }
}
