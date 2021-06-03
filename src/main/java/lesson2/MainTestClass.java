package lesson2;

import java.util.Random;

public class MainTestClass {
    public static void main(String[] args) {

        ArrayIntContainerImpl array1 = new ArrayIntContainerImpl(10);
        ArrayIntContainerImpl array2 = new ArrayIntContainerImpl(5);
        ArrayIntContainerImpl array3 = new ArrayIntContainerImpl(1);

        for (int i = 0; i < 100000; i++) {
            array1.add(new Random().nextInt(50));
            array2.add(new Random().nextInt(70));
            array3.add(new Random().nextInt(90));
        }

        long t1, t2;

        t1 = System.currentTimeMillis();
        array1.sortBubble();
        t2 = System.currentTimeMillis() - t1;
        System.out.println("Время пузырьковой сортировки " + t2);

        t1 = System.currentTimeMillis();
        array2.sortSelect();
        t2 = System.currentTimeMillis() - t1;
        System.out.println("Время сортировки методом выбора " + t2);

        t1 = System.currentTimeMillis();
        array3.sortInsert();
        t2 = System.currentTimeMillis() - t1;
        System.out.println("Время сортировки методом вставки " + t2);


    }
}
