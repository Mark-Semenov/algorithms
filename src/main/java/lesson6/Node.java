package lesson6;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Node<E extends Comparable<? super E>> {

    private Node<E> right;
    private Node<E> left;
    private E value;

    public Node(E value) {
        this.value = value;
    }

    public boolean isLeaf(){
        return right == null && left == null;
    }


}
