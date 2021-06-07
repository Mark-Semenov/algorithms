package lesson6;

public interface Tree<E extends Comparable<? super E>> {

    boolean add(Node<E> node);

    boolean contains(Node<E> node);

    boolean isEmpty();

    boolean remove(Node<E> node);

    void display();

}
