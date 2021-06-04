package lesson5.backpack;

import lesson5.backpack.elements.Product;

import java.util.ArrayList;
import java.util.List;

public class Backpack<E extends Product> {

    private final List<E> collection;
    private final int capacity;
    private int bestPrice;

    public Backpack(int capacity) {
        this.collection = new ArrayList<>();
        this.capacity = capacity;
    }

    private void addIfBest(List<E> products) {
        if (collection.isEmpty()) {
            if (calcTotalWeight(products) <= capacity) {
                collection.addAll(products);
                bestPrice = calcTotalPrice(products);
            }
        } else {
            if (calcTotalWeight(products) <= capacity && calcTotalPrice(products) > bestPrice) {
                collection.clear();
                collection.addAll(products);
                bestPrice = calcTotalPrice(products);
            }
        }
    }

    public void checkout(List<E> products) {
        if (!products.isEmpty()) {
            addIfBest(products);
        }

        for (int i = 0; i < products.size(); i++) {
            List<E> list = new ArrayList<>(products);
            list.remove(i);
            checkout(list);
        }

    }

    public int calcTotalWeight(List<E> elements) {
        int w = 0;
        for (Product product : elements) {
            w += product.getWeight();
        }
        return w;
    }

    public int calcTotalPrice(List<E> elements) {
        int price = 0;
        for (Product product : elements) {
            price += product.getPrice();
        }
        return price;
    }


    public List<E> getCollection() {
        return collection;
    }


}
