package edu.etu.web;

import edu.etu.web.models.ItemEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Алексей on 01.04.2015.
 */
public class Cart {
    private HashMap<ItemEntity, Integer> cart = new HashMap<ItemEntity, Integer>();

    public HashMap<ItemEntity, Integer> getCart () {
        return cart;
    }

    public void addItem(ItemEntity item, Integer count) {
        Integer value = cart.get(item);

        if (value != null) {
            count += value;
        }

        cart.put(item, count);
    }

    public void reset() {
        cart = new HashMap<ItemEntity, Integer>();
    }

    public double getTotalSum() {
        double total = 0.0;

        for (Map.Entry<ItemEntity, Integer> entry : cart.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }

        return total;
    }
}
