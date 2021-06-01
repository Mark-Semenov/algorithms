import java.util.Arrays;

public class ArrayIntContainerImpl implements ArrayIntContainer {

    private int[] array;
    private int capacity;
    private int index;

    public ArrayIntContainerImpl() {
    }

    public ArrayIntContainerImpl(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
    }

    @Override
    public boolean deleteElementByIndex(int index) {

        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }

        if (index <= array.length - 1) {
            array = Arrays.copyOf(array, array.length - 1);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteElement(int value) {

        if (Arrays.stream(array).anyMatch(v -> v == value)) {
            array = Arrays.stream(array).sorted().filter(v -> v != value).toArray();
            return true;
        }

        return false;
    }

    @Override
    public void add(int value) {
        array[index++] = value;
        if (index >= array.length) {
            array = Arrays.copyOf(array, array.length + 1);
        }
    }

    @Override
    public int findByIndex(int index) {
        if (index <= array.length - 1) {
            return Arrays.stream(array).filter(value -> value == array[index]).iterator().nextInt();
        }
        return -1;
    }

    public boolean contains(int value) {
        return Arrays.stream(array).anyMatch(e -> e == value);
    }


    public void display() {
        Arrays.stream(array).forEach(ArrayIntContainerImpl::printFormat);
    }

    public int size() {
        return array.length;
    }

    public static void printFormat(int a) {
        System.out.print(a + " ");
    }

    //Сортировка
    @Override
    public void sortBubble() {
        for (int out = array.length - 1; out >= 1; out--) {
            for (int i = 0; i < out; i++) {
                if (array[i] > array[i + 1]) {
                    change(i, i + 1);
                }
            }
        }
    }

    private void change(int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    @Override
    public void sortSelect() {
        int marker;
        for (int out = 0; out < array.length; out++) {
            marker = out;
            for (int in = out + 1; in < array.length; in++) {
                if (array[in] < array[marker]) {
                    marker = in;
                }
            }
            change(out, marker);
        }
    }

    @Override
    public void sortInsert() {
        int in;
        for (int out = 1; out < array.length; out++) {
            int temp = array[out];
            in = out;
            while (in > 0 && array[in - 1] >= temp) {
                array[in] = array[in - 1];
                --in;
            }
            array[in] = temp;
        }
    }
}
