package lesson5.backpack;

import lesson5.backpack.elements.Product;
import lesson5.backpack.elements.Notebook;
import lesson5.backpack.elements.Phone;
import lesson5.backpack.elements.Printer;

import java.util.List;

public class TestBackpack {

    public static void main(String[] args) {

        List<Product> collection = List.of(
                new Notebook("Apple MacBook Pro", 2, 3900),
                new Printer("HP LaserJet Enterprise", 10, 6500),
                new Phone("Samsung Galaxy S21", 1, 1100),
                new Phone("Huawei P40 Lite", 1, 800),
                new Phone("Redmi Note 10", 1, 500));

        Backpack<Product> backpack = new Backpack<>(8);

        backpack.checkout(collection);
        System.out.println(backpack.getCollection());

    }
}
