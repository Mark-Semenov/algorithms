package lesson3;

public class DequeImpl<E> extends QueueImpl<E> implements Deque<E> {

    public DequeImpl(int maxSize) {
        super(maxSize);
    }

    @Override
    public boolean insertRight(E value) {

        if (isFull()) {
            return false;
        }
        if (head == HEAD_DEFAULT)
            head = data.length;

        data[--head] = value;
        size++;

        return true;

    }

    @Override
    public boolean insertLeft(E value) {
        return super.insert(value);
    }

    @Override
    public E removeRight() {
        return super.remove();
    }

    @Override
    public E removeLeft() {
        if (isEmpty()) {
            return null;
        }
        if (tail == TAIL_DEFAULT)
            tail = data.length - 1;

        size--;
        return data[tail--];

    }

    @Override
    public E[] getData() {
        return super.getData();
    }
}
